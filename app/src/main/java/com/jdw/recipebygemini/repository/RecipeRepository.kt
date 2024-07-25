package com.jdw.recipebygemini.repository

import android.content.Context
import com.jdw.recipebygemini.data.model.Dish
import com.jdw.recipebygemini.data.roomdb.RecipeDao
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class RecipeRepository @Inject constructor (
    private val recipeDao: RecipeDao,
){
    suspend fun getAllDishes() = recipeDao.getAllDishes()
    suspend fun insertDish(dish: Dish) = recipeDao.insertDish(dish)
    suspend fun deleteDish(dish: Dish) = recipeDao.deleteDish(dish)
}