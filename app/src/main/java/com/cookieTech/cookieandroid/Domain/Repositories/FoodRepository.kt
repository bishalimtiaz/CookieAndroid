package com.cookieTech.cookieandroid.Domain.Repositories

import com.cookieTech.cookieandroid.Domain.Models.Food
import com.cookieTech.cookieandroid.Domain.Models.FoodWithVitaminsAndMinerals
import com.cookieTech.cookieandroid.Domain.Models.SearchFoodItem
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