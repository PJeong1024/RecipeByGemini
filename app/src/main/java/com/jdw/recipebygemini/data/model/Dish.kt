package com.jdw.recipebygemini.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.jdw.recipebygemini.utils.IngredientListConverter
import com.jdw.recipebygemini.utils.StringListConverter

@Entity(tableName = "dishes")
data class Dish(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val dish_name: String,

    @TypeConverters(IngredientListConverter::class)
    val ingredients: List<Ingredient>,

    @TypeConverters(StringListConverter::class)
    val steps: List<String>
)