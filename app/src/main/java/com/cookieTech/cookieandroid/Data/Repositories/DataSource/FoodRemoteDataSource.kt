package com.cookieTech.cookieandroid.Data.repositories.DataSource

import com.cookieTech.cookieandroid.domain.models.*
import kotlinx.coroutines.flow.Flow

interface FoodRemoteDataSource {

    fun searchFood(query: String): Flow<List<Food>>

    fun createFood(food:Food): Long
    fun createFood(food: Food,vitamins: Vitamins): Long
    fun createFood(food: Food, vitamins: Vitamins, minerals: Minerals)
    fun createFood(foodWithVitaminsAndMinerals: FoodWithVitaminsAndMinerals)
    suspend fun searchFoodMinimal(
        query: String,
        itemPerPage: Int,
        pageNum: Int
    ): CallResponse<List<SearchFoodItem>>
}