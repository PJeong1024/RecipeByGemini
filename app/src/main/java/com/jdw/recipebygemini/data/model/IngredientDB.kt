package com.jdw.recipebygemini.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ingredient")
data class IngredientDB(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,

    val name : Int = 0,
)
