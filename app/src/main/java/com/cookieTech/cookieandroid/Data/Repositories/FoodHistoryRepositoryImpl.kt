package com.cookieTech.cookieandroid.Data.Repositories

import com.cookieTech.cookieandroid.Data.Repositories.DataSource.FoodHistoryDataSource
import com.cookieTech.cookieandroid.domain.models.FoodHistory
import com.cookieTech.cookieandroid.domain.repositories.FoodHistoryRepository

class FoodHistoryRepositoryImpl(
    val foodHistoryDataSource: FoodHistoryDataSource
)
    :FoodHistoryRepository {


    override fun addFoodToHistory(food: FoodHistory):Long {
        return foodHistoryDataSource.createFoodHistory(history).toLong()
    }

    override fun deleteFoodHistory(foodHistory: FoodHistory): Long {
        return foodHistoryDataSource.deleteFoodHistory(foodHistory = foodHistory)
    }


}