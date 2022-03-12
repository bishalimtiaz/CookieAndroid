package com.cookieTech.cookieandroid.Data.Repositories.DataSourceImpl

import com.cookieTech.cookieandroid.Data.Dao.FoodDao
import com.cookieTech.cookieandroid.Data.Database.AppDatabase
import com.cookieTech.cookieandroid.Data.Database.calculateScore
import com.cookieTech.cookieandroid.Data.Repositories.DataSource.FoodDataSource
import com.cookieTech.cookieandroid.Domain.Models.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FoodDataSourceImpl(val appDatabase: AppDatabase):FoodDataSource {
    val foodDao = appDatabase.foodDao
    override fun createFood(food: Food): Long {
        return foodDao.insert(food)
    }

    override fun createFood(food: Food, vitamins: Vitamins): Long {
        TODO("Not yet implemented")
    }

    override fun createFood(food: Food, vitamins: Vitamins, minerals: Minerals) {
        TODO("Not yet implemented")
    }

    override fun createFood(foodWithVitaminsAndMinerals: FoodWithVitaminsAndMinerals) {
        TODO("Not yet implemented")
    }

    override fun getFoodById(id: Int): Flow<Food> {
        return foodDao.getFoodById(id)
    }

    override fun searchFood(query: String): Flow<List<Food>> {
        TODO("Not yet implemented")
    }

    override fun deleteFood(food: Food): Long {
        return foodDao.delete(food).toLong()
    }

    override fun updateFood(food: Food): Long {
        return foodDao.update(food).toLong()
    }

    override fun upsertFood(food: Food): Long {
        return foodDao.upsert(food)
    }

    override fun getAllFood(): Flow<List<Food>> {
        return foodDao.getAllFood()
    }

    override fun getFoodDetailsById(id: Long): Flow<FoodWithVitaminsAndMinerals> {
        return foodDao.getFoodDetailsById(id)
    }

    override fun searchFoodMinimal(query: String): Flow<List<SearchFoodItem>> {
        return foodDao.searchFoodMinimal("*$query*")
    }

    override fun searchFoodWithRanking(query: String): Flow<List<SearchFoodItem>> {
        return foodDao.searchFoodMinimalWithMatchInfo("*$query*").map {
            it.sortedByDescending { value-> calculateScore(value.matchInfo) }.map { value->value.food }
        }
    }


}