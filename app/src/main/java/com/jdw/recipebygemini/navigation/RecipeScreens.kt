package com.jdw.recipebygemini.navigation

import android.content.res.Resources
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ListAlt
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ListAlt
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import com.jdw.recipebygemini.R


enum class RecipeScreens {
    HomeScreen,
    SplashScreen,
    LoginScreen,
    CreateAccountScreen,
    SearchScreen,
    DetailScreen,
    UpdateScreen,
    ReaderStatsScreen;

    companion object {
        fun fromRoute(route: String?): RecipeScreens = when (route?.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            SplashScreen.name -> SplashScreen
            LoginScreen.name -> LoginScreen
            CreateAccountScreen.name -> CreateAccountScreen
            SearchScreen.name -> SearchScreen
            DetailScreen.name -> DetailScreen
            UpdateScreen.name -> UpdateScreen
            ReaderStatsScreen.name -> ReaderStatsScreen

            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}

enum class BottomNaviBarScreen(val label: String, val icon: ImageVector, val route: String) {
    GeminiRecipe("Gemini Recipe", Icons.Filled.Star, "geminirecipe"),
    RecipeList("Recipe List", Icons.AutoMirrored.Filled.ListAlt, "recipelist"),
    Settings("Settings", Icons.Filled.Settings, "settings")
}