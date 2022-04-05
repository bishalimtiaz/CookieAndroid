package com.cookieTech.cookieandroid.Data.Repositories.DataSourceImpl

import com.cookieTech.cookieandroid.Data.Database.AppDatabase
import com.cookieTech.cookieandroid.Data.Repositories.DataSource.FoodHistoryDataSource
import com.cookieTech.cookieandroid.domain.models.Food
import com.cookieTech.cookieandroid.domain.models.FoodHistory
import kotlinx.coroutines.flow.Flow

class FoodHistoryDataSourceImpl(
    val appDatabase: AppDatabase
):FoodHistoryDataSource {

    val historyDao = appDatabase.foodHistoryDao
    override fun createFoodHistory(foodHistory: FoodHistory): Long {
        return historyDao.insert(foodHistory)
    }

    override fun getFoodHistoryById(id: Int): Flow<FoodHistory> {
        TODO("Not yet implemented")
    }

    override fun searchFoodHistory(query: String): Flow<List<Food>> {
        TODO("Not yet implemented")
    }

    override fun deleteFoodHistory(foodHistory: FoodHistory): Long {
        TODO("Not yet implemented")
    }

    override fun updateFoodHistory(foodHistory: FoodHistory): Int {
        TODO("Not yet implemented")
    }

    override fun upsertFoodHistory(foodHistory: FoodHistory): Int {
        TODO("Not yet implemented")
    }

    override fun getTodayFood(): Flow<List<Food>> {
        TODO("Not yet implemented")
    }

    override fun getTodayBreakFast(): Flow<List<Food>> {
        TODO("Not yet implemented")
    }

}