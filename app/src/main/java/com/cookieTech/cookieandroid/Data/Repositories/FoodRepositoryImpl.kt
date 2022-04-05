package com.cookieTech.cookieandroid.Data.Repositories

import com.cookieTech.cookieandroid.Data.Repositories.DataSource.FoodDataSource
import com.cookieTech.cookieandroid.domain.models.Food
import com.cookieTech.cookieandroid.domain.models.FoodWithVitaminsAndMinerals
import com.cookieTech.cookieandroid.domain.models.SearchFoodItem
import com.cookieTech.cookieandroid.domain.repositories.FoodRepository
import kotlinx.coroutines.flow.Flow

class FoodRepositoryImpl(
    val foodDataSource: FoodDataSource
):FoodRepository
{
    override fun createFood(food: Food): Long {
        return foodDataSource.createFood(food)
    }

    override fun searchFood(string: String): Flow<List<Food>> {
        TODO("Not yet implemented")
    }

    override fun updateFood(food: Food): Long {
        return foodDataSource.updateFood(food = food)
    }

    override fun deleteFood(food: Food): Long {
        return foodDataSource.deleteFood(food)
    }

    override fun upsertFood(food: Food): Long {
        TODO("Not yet implemented")
    }

    override fun getFoodById(id: Long): Flow<Food> {
        TODO("Not yet implemented")
    }

    override fun searchFoodMinimal(query: String): Flow<List<SearchFoodItem>> {
        return foodDataSource.searchFoodMinimal(query)
    }

    override fun selectFood(id: Long): Flow<FoodWithVitaminsAndMinerals> {
        return foodDataSource.getFoodDetailsById(id)
    }


    override fun searchFoodWithRanking(query: String): Flow<List<SearchFoodItem>> {
        return foodDataSource.searchFoodWithRanking(query = query)
    }
}