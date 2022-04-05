package com.cookieTech.cookieandroid.Data.Repositories.DataSource

import com.cookieTech.cookieandroid.domain.models.*
import kotlinx.coroutines.flow.Flow


interface FoodDataSource {
    fun createFood(food:Food): Long
    fun createFood(food: Food,vitamins: Vitamins): Long
    fun createFood(food: Food,vitamins: Vitamins,minerals: Minerals)
    fun createFood(foodWithVitaminsAndMinerals: FoodWithVitaminsAndMinerals)

    fun getFoodById(id:Int): Flow<Food>
    fun searchFood(query: String):Flow<List<Food>>

    fun deleteFood(food: Food):Long
    fun updateFood(food: Food):Long
    fun upsertFood(food: Food):Long

    fun getAllFood():Flow<List<Food>>


    fun getFoodDetailsById(id: Long): Flow<FoodWithVitaminsAndMinerals>
    fun searchFoodMinimal(query: String): Flow<List<SearchFoodItem>>

    fun searchFoodWithRanking(query: String): Flow<List<SearchFoodItem>>

}