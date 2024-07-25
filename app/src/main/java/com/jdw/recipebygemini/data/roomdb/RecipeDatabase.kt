package com.jdw.recipebygemini.data.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jdw.recipebygemini.data.model.Dish
import com.jdw.recipebygemini.utils.IngredientListConverter
import com.jdw.recipebygemini.utils.StringListConverter

@Database(entities = [Dish::class], version = 1, exportSchema = false)
@TypeConverters(IngredientListConverter::class, StringListConverter::class)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}