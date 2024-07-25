package com.jdw.recipebygemini.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "amounts")
data class IngredientAmount(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,

    @ColumnInfo("ingredient_id")
    val ingredientId : Int = 0,

    val amount :  Int = 0
)
