package com.cookieTech.cookieandroid.data.remote

import android.app.appsearch.SearchResult
import retrofit2.http.GET
import retrofit2.http.Query


interface CookieApi {
    @GET("food/search")
    suspend fun searchAllImages(
        @Query("query") query: String,
        @Query("per_page")perPage: Int
    ): SearchResult
}