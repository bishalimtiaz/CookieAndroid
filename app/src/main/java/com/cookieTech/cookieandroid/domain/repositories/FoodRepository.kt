package com.cookieTech.cookieandroid.domain.repositories

import com.cookieTech.cookieandroid.domain.models.Food
import com.cookieTech.cookieandroid.domain.models.FoodWithVitaminsAndMinerals
import com.cookieTech.cookieandroid.domain.models.SearchFoodItem
import kotlinx.coroutines.flow.Flow


interface FoodRepository {
    fun createFood(food: Food):Long

    fun searchFood(string: String):Flow<List<Food>>

    fun updateFood(food: Food):Long

    fun deleteFood(food: Food):Long

    fun upsertFood(food: Food):Long

    fun getFoodById(id:Long):Flow<Food>

    fun searchFoodMinimal(query: String): Flow<List<SearchFoodItem>>

    fun selectFood(id: Long): Flow<FoodWithVitaminsAndMinerals>


    fun searchFoodWithRanking(query: String): Flow<List<SearchFoodItem>>

}