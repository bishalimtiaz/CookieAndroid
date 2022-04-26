package com.cookieTech.cookieandroid.Data.Repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.cookieTech.cookieandroid.Data.Repositories.DataSource.FoodLocalDataSource
import com.cookieTech.cookieandroid.Data.pagging.SearchFoodMinimalPagingSource
import com.cookieTech.cookieandroid.Data.repositories.DataSource.FoodRemoteDataSource
import com.cookieTech.cookieandroid.domain.models.Food
import com.cookieTech.cookieandroid.domain.models.FoodWithVitaminsAndMinerals
import com.cookieTech.cookieandroid.domain.models.SearchFoodItem
import com.cookieTech.cookieandroid.domain.repositories.FoodRepository
import com.cookieTech.cookieandroid.domain.useCases.ITEM_PER_PAGE
import io.reactivex.Observable
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

class FoodRepositoryImpl(
    val foodRemoteDataSource: FoodRemoteDataSource,
    val foodDataSource: FoodLocalDataSource
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

    override suspend fun searchFoodMinimal(query: String): Flow<PagingData<SearchFoodItem>> {
        return Pager(
            config = PagingConfig(ITEM_PER_PAGE),
            pagingSourceFactory = {
                SearchFoodMinimalPagingSource(foodRemoteDataSource, query)
            }
        ).flow
    }

    override fun selectFood(id: Long): Flow<FoodWithVitaminsAndMinerals> {
        return foodDataSource.getFoodDetailsById(id)
    }


    override fun searchFoodWithRanking(query: String): Flow<List<SearchFoodItem>> {
        return foodDataSource.searchFoodWithRanking(query = query)
    }
}