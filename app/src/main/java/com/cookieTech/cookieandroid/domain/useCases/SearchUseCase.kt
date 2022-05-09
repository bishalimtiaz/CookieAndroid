package com.cookieTech.cookieandroid.domain.useCases

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.cookieTech.cookieandroid.domain.models.FoodHistory
import com.cookieTech.cookieandroid.domain.models.FoodWithVitaminsAndMinerals
import com.cookieTech.cookieandroid.domain.models.SearchFoodItem
import com.cookieTech.cookieandroid.domain.repositories.FoodHistoryRepository
import com.cookieTech.cookieandroid.domain.repositories.FoodRepository
import kotlinx.coroutines.flow.Flow

const val ITEM_PER_PAGE = 10
class SearchUseCase(
    val foodRepository: FoodRepository
//    val foodHistoryRepository: FoodHistoryRepository
) {

    suspend fun searchFood(query:String):Flow<PagingData<SearchFoodItem>>{
        return foodRepository.searchFoodMinimal(query)
    }

    suspend fun searchFoodWithRanking(query:String):Flow<List<SearchFoodItem>>{
        return foodRepository.searchFoodWithRanking(query)
    }


    suspend fun selectFood(id:Long):Flow<FoodWithVitaminsAndMinerals>{
        return foodRepository.selectFood(id)
    }

    fun addFoodToHistory(item: SearchFoodItem) {
//        foodHistoryRepository.addFoodToHistory(item)
    }


}