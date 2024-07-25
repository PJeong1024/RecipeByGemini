package com.jdw.recipebygemini.data.roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jdw.recipebygemini.data.model.Dish

@Dao
interface RecipeDao {
    @Query("SELECT * FROM dishes")
    suspend fun getAllDishes(): List<Dish>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDish(dish: Dish)

    @Delete
    suspend fun deleteDish(dish: Dish)
}