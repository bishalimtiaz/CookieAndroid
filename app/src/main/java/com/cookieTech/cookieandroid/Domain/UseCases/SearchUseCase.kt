package com.cookieTech.cookieandroid.Domain.UseCases

import com.cookieTech.cookieandroid.Domain.Models.Food
import com.cookieTech.cookieandroid.Domain.Models.FoodWithVitaminsAndMinerals
import com.cookieTech.cookieandroid.Domain.Models.SearchFoodItem
import com.cookieTech.cookieandroid.Domain.Repositories.FoodRepository
import kotlinx.coroutines.flow.Flow

class SearchUseCase(
    val foodRepository: FoodRepository
) {

    suspend fun searchFood(query:String):Flow<List<SearchFoodItem>>{
        return foodRepository.searchFoodMinimal(query)
    }

    suspend fun searchFoodWithRanking(query:String):Flow<List<SearchFoodItem>>{
        return foodRepository.searchFoodWithRanking(query)
    }


    suspend fun selectFood(id:Long):Flow<FoodWithVitaminsAndMinerals>{
        return foodRepository.selectFood(id)
    }



}