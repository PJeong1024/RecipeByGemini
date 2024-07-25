package com.jdw.recipebygemini.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jdw.recipebygemini.screens.MainScreen
import com.jdw.recipebygemini.screens.viewmodels.MainViewModel

@Composable
fun RecipeAppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = RecipeScreens.HomeScreen.name) {
//        composable(ReaderScreens.SplashScreen.name) {
//            ReaderSplashScreen(navController)
//        }
        composable(RecipeScreens.HomeScreen.name) {
            val viewModel = hiltViewModel<MainViewModel>()
            MainScreen(navController, viewModel)
        }

//        composable(ReaderScreens.HomeScreen.name) {
//            val viewModel = hiltViewModel<MainViewModel>()
//            HomeScreen(navController, viewModel, paddingValues)
//        }
//
//        composable(ReaderScreens.LoginScreen.name) {
//            ReaderLoginScreen(navController)
//        }
//
//        composable(ReaderScreens.ReaderStatsScreen.name) {
//            val viewModel = hiltViewModel<HomeScreenViewModel>()
//            ReaderStatsScreen(navController, viewModel)
//        }
//
//        composable(ReaderScreens.SearchScreen.name) {
//            val viewModel = hiltViewModel<BookSearchViewModel>()
//            SearchScreen(navController, viewModel)
//        }
//
//        val detailName = ReaderScreens.DetailScreen.name
//        composable("$detailName/{bookId}", arguments = listOf(navArgument("bookId"){
//            type = NavType.StringType
//        })) {
//            backStackEntry ->
//            val viewModel = hiltViewModel<DetailsViewModel>()
//            backStackEntry.arguments?.getString("bookId").let {
//                value ->
//                BookDetailsScreen(navController, bookId = value.toString(), viewModel)
//            }
//        }
//
//        val updateName = ReaderScreens.UpdateScreen.name
//        composable("$updateName/{bookItemID}", arguments = listOf(navArgument("bookItemID"){
//            type = NavType.StringType
//        })) {
//                backStackEntry ->
//            val viewModel = hiltViewModel<HomeScreenViewModel>()
//            backStackEntry.arguments?.getString("bookItemID").let {
//                    value ->
//                BookUpdateScreen(navController, bookItemID = value.toString(), viewModel = viewModel)
//            }
//        }
    }

}