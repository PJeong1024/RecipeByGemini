package com.jdw.recipebygemini.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.jdw.recipebygemini.components.DishCard
import com.jdw.recipebygemini.components.InputField
import com.jdw.recipebygemini.screens.viewmodels.MainViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel(),
    paddingValues: PaddingValues
) {
    val dataList = viewModel.dishes.collectAsState().value
    Log.d("HomeScreen", "dataList.dish_list : ${dataList.dish_list} ")

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        DisplayResult(navController, viewModel)
    }
}

@Composable
fun DisplayResult(navController: NavController, viewModel: MainViewModel) {
    val context = LocalContext.current
    val outputData = viewModel.outputData.collectAsState().value
    val dishList = viewModel.dishes.collectAsState().value.dish_list
    val inputString = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        InputForm(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            valueState = inputString
        )

        Spacer(modifier = Modifier.padding(10.dp))

        Button(
            onClick = {
                if (inputString.value.isNotEmpty()) {
                    viewModel.getRecipes(inputString.value)
                } else {
                    Toast.makeText(context, "Please input the ingredient list", Toast.LENGTH_SHORT)
                        .show()
                }
            },
            enabled = outputData.loading != true
        ) {
            Text(text = "Ask the recipe", fontSize = 20.sp)
        }

        Spacer(modifier = Modifier.padding(10.dp))

        when {
            outputData.loading == true -> {
                CircularProgressIndicator()
            }

            outputData.e != null -> {
                Text(
                    text = "⚠ 오류: ${outputData.e?.message ?: "Unknown error"}",
                    color = Color.Red
                )
            }

            dishList.isEmpty() -> {
                Text(text = "There's no recipe from Gemini")
            }

            else -> {
                LazyColumn(modifier = Modifier.padding(10.dp)) {
                    items(dishList) { dish ->
                        DishCard(dish, viewModel, context = context, isFromDB = false)
                    }
                }
            }
        }
    }
}


@Composable
fun InputForm(
    modifier: Modifier = Modifier,
    valueState: MutableState<String>,
    hint: String = "Input ingredients you have with space(' ')",
) {
    Column {
        val keyboardController = LocalSoftwareKeyboardController.current

        InputField(valueState = valueState, labelId = hint, enabled = true,
            onAction = KeyboardActions {
                keyboardController?.hide()
            }
        )
    }
}
