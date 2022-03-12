package com.cookieTech.cookieandroid.Data.Repositories

import com.cookieTech.cookieandroid.Data.Repositories.DataSource.FoodHistoryDataSource
import com.cookieTech.cookieandroid.Domain.Models.FoodHistory
import com.cookieTech.cookieandroid.Domain.Repositories.FoodHistoryRepository

class FoodHistoryRepositoryImpl(
    val foodHistoryDataSource: FoodHistoryDataSource
)
    :FoodHistoryRepository {


    override fun addFoodToHistory(history: FoodHistory):Long {
        return foodHistoryDataSource.createFoodHistory(history).toLong()
    }

    override fun deleteFoodHistory(foodHistory: FoodHistory): Long {
        return foodHistoryDataSource.deleteFoodHistory(foodHistory = foodHistory)
    }


}