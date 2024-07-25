package com.jdw.recipebygemini.screens.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import com.google.gson.Gson
import com.jdw.recipebygemini.data.DataOrException
import com.jdw.recipebygemini.data.Resources
import com.jdw.recipebygemini.data.model.Dish
import com.jdw.recipebygemini.data.model.DishList
import com.jdw.recipebygemini.repository.RecipeRepository
import com.jdw.recipebygemini.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val generativeModel: GenerativeModel,
    private val repository: RecipeRepository
) : ViewModel() {
    private val _outputData = MutableStateFlow<DataOrException<String, Boolean, Exception>>(
        DataOrException("", false, null)
    )
    val outputData: StateFlow<DataOrException<String, Boolean, Exception>> =
        _outputData.asStateFlow()

    private val _dishes = MutableStateFlow<DishList>(DishList())
    val dishes = _dishes.asStateFlow()

    private val _dishesFromDB = MutableStateFlow<List<Dish>>(emptyList())
    val dishesFromDB = _dishesFromDB.asStateFlow()

    private val _imageResult = MutableStateFlow<String>("")
    val imageResult = _imageResult.asStateFlow()

    init {
        getAllDishes()
    }

    private fun getAllDishes() {
        viewModelScope.launch {
            _dishesFromDB.value = repository.getAllDishes()
        }
    }

    fun insertDish(dish: Dish) {
        viewModelScope.launch {
            repository.insertDish(dish)
            getAllDishes() // Refresh the list
        }
    }

    fun deleteDish(dish: Dish) {
        viewModelScope.launch {
            repository.deleteDish(dish)
            getAllDishes() // Refresh the list
        }
    }

    fun getImages(ingredients: String) {
        viewModelScope.launch {
            try {
                val inputText = Constants.IMAGE_REQUEST_TEXT + ingredients
                _outputData.value.loading = true
                _outputData.value.data = generativeModel.generateContent(inputText).text
                if (!_outputData.value.data.isNullOrEmpty()) {
                    Log.d("getImages", "succeed to received : ${_outputData.value.data} ")
                    _imageResult.value = _outputData.value.data.toString()
                    _outputData.value.loading = false
                }
            } catch (e: Exception) {
                _outputData.value.e = e
                _outputData.value.loading = false
            }
        }
    }

    fun getRecipes(ingredients: String) {
        viewModelScope.launch {
            try {
                val inputText = Constants.BASEMENT_TEXT + ingredients
                _outputData.value.loading = true
                _outputData.value.data = generativeModel.generateContent(inputText).text
                if (!_outputData.value.data.isNullOrEmpty()) {
                    Log.d("getRecipes", "succeed to received : ${_outputData.value.data} ")
                    _dishes.value = Gson().fromJson(
                        _outputData.value.data.toString().replace("json", "", ignoreCase = true)
                            .replace("```", ""), DishList::class.java
                    )
                    _outputData.value.loading = false
                }
            } catch (e: Exception) {
                _outputData.value.e = e
                _outputData.value.loading = false
            }
        }
    }

    suspend fun getResult(inputText: String): Resources<String> {
        val response = try {
            Resources.Loading(true)
            generativeModel.generateContent(inputText).text ?: ""
        } catch (e: Exception) {
            return Resources.Error(message = e.message.toString())
        }
        Resources.Loading(false)

        return Resources.Success(data = response)
    }
}