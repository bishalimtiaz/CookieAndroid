package com.cookieTech.cookieandroid.Data.repositories.DataSourceImpl

import android.util.Log
import com.cookieTech.cookieandroid.Data.repositories.DataSource.FoodRemoteDataSource
import com.cookieTech.cookieandroid.data.remote.FoodApi
import com.cookieTech.cookieandroid.domain.models.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import retrofit2.Call
import retrofit2.Response

class FoodRemoteDataSourceImpl(
    val foodApi: FoodApi
) : FoodRemoteDataSource{
    override fun searchFood(query: String): Flow<List<Food>> {
        TODO("Not yet implemented")
    }

    override suspend fun searchFoodMinimal(query: String,itemPerPage:Int,pageNum:Int): CallResponse<List<SearchFoodItem>> {
        val response = foodApi.searchAllFoods(query,itemPerPage,pageNum)
        val callResponse = CallResponse<List<SearchFoodItem>>()
        if(response.isSuccessful){
            callResponse.networkState = NetworkState.Success
            callResponse.message = "Searched successfully"
            callResponse.data = response.body()
        }else{
            callResponse.networkState = NetworkState.Failed
            callResponse.message = response.message()
        }
        return callResponse
    }

    override fun createFood(food: Food): Long {
        TODO("Not yet implemented")
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
}