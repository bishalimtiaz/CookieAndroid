package com.cookieTech.cookieandroid.data.remote

import android.app.appsearch.SearchResult
import com.cookieTech.cookieandroid.domain.models.SearchFoodItem
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface FoodApi {
    @GET("food/search/{keyword}/")
    suspend fun searchAllFoods(
        @Path("keyword") keyword: String,
        @Query("item_per_page") itemPerPage: Int,
        @Query("page_num") pageNum: Int
    ): Response<List<SearchFoodItem>>
}