package com.cookieTech.cookieandroid.Data.Repositories.DataSource

import com.cookieTech.cookieandroid.domain.models.*
import kotlinx.coroutines.flow.Flow

interface FoodHistoryDataSource {

    fun createFoodHistory(foodHistory: FoodHistory): Long

    fun getFoodHistoryById(id:Int): Flow<FoodHistory>
    fun searchFoodHistory(query: String): Flow<List<Food>>

    fun deleteFoodHistory(foodHistory: FoodHistory):Long
    fun updateFoodHistory(foodHistory: FoodHistory):Int
    fun upsertFoodHistory(foodHistory: FoodHistory):Int

    fun getTodayFood(): Flow<List<Food>>

    fun getTodayBreakFast():Flow<List<Food>>
}