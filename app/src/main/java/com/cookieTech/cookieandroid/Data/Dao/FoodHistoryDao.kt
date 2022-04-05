package com.cookieTech.cookieandroid.Data.Dao

import androidx.room.Dao
import androidx.room.Query
import com.cookieTech.cookieandroid.domain.models.FoodHistory
import com.cookieTech.cookieandroid.domain.models.FoodHistoryAndFood
import kotlinx.coroutines.flow.Flow
import java.util.*

@Dao
abstract class FoodHistoryDao: BaseDao<FoodHistory>() {

    @Query("select * from food_history_table")
    abstract fun getAllFoodHistory(): Flow<List<FoodHistory>>

    @Query("select * from food_history_table where date = :date ")
    abstract fun getAllFoodHistoryByDate(date: Calendar = Calendar.getInstance()): Flow<List<FoodHistoryAndFood>>

    @Query("select * from food_history_table where id = :id")
    abstract fun getFoodHistoryById(id: Long): Flow<FoodHistoryAndFood>

    @Query("select * from food_history_table where date = :date and meal_type = :mealType")
    abstract fun getFoodHistoryByDateAndMealType(date: Calendar, mealType: String): Flow<List<FoodHistoryAndFood>>


}