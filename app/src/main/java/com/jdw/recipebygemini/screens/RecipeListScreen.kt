package com.jdw.recipebygemini.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.jdw.recipebygemini.components.DishCard
import com.jdw.recipebygemini.screens.viewmodels.MainViewModel

@Composable
fun SecondScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel(),
    paddingValues: PaddingValues
) {
    val context = LocalContext.current
    val dishesFromDB = viewModel.dishesFromDB.collectAsState().value

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        if (dishesFromDB.isNotEmpty()) {
            LazyColumn(modifier = Modifier.padding(horizontal = 10.dp)) {
                items(dishesFromDB) { dish ->
                    DishCard(dish, viewModel, context = context, true)
                    Spacer(modifier = Modifier.padding(bottom = 10.dp))
                }
            }
        } else {
            Text(text = "No dishes")
        }

    }
}
