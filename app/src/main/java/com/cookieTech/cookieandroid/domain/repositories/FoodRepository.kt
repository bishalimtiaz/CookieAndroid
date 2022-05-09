package com.cookieTech.cookieandroid.domain.repositories

import androidx.paging.PagingData
import com.cookieTech.cookieandroid.domain.models.Food
import com.cookieTech.cookieandroid.domain.models.FoodWithVitaminsAndMinerals
import com.cookieTech.cookieandroid.domain.models.SearchFoodItem
import io.reactivex.Observable
import io.reactivex.ObservableSource
import kotlinx.coroutines.flow.Flow
import java.util.*


interface FoodRepository {
    fun createFood(food: Food):Long

    fun searchFood(string: String):Flow<List<Food>>

    fun updateFood(food: Food):Long

    fun deleteFood(food: Food):Long

    fun upsertFood(food: Food):Long

    fun getFoodById(id:Long):Flow<Food>


    fun selectFood(id: Long): Flow<FoodWithVitaminsAndMinerals>


    fun searchFoodWithRanking(query: String): Flow<List<SearchFoodItem>>

    suspend fun searchFoodMinimal(
        query: String
    ): Flow<PagingData<SearchFoodItem>>
}