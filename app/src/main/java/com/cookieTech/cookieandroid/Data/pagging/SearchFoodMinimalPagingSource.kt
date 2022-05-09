package com.cookieTech.cookieandroid.Data.pagging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.cookieTech.cookieandroid.Data.repositories.DataSource.FoodRemoteDataSource
import com.cookieTech.cookieandroid.data.remote.FoodApi
import com.cookieTech.cookieandroid.domain.models.SearchFoodItem
import com.cookieTech.cookieandroid.domain.useCases.ITEM_PER_PAGE
import kotlinx.coroutines.flow.firstOrNull

class SearchFoodMinimalPagingSource(
    val foodRemoteDataSource: FoodRemoteDataSource,
    val query:String
): PagingSource<Int, SearchFoodItem>() {
    override fun getRefreshKey(state: PagingState<Int, SearchFoodItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SearchFoodItem> {
        val currentPage = params.key ?: 1
        return try {
            val nextPageNumber = params.key ?: 1
            val response = foodRemoteDataSource.searchFoodMinimal(query, ITEM_PER_PAGE,nextPageNumber)
            Log.d("paging_test", "load: " + response.data + " " + response.data.isNullOrEmpty())
            val endOfPaginationReached = response.data.isNullOrEmpty()

            if (!response.data.isNullOrEmpty()) {
                LoadResult.Page(
                    data = response.data!!,
                    prevKey = if (currentPage == 1) null else currentPage - 1,
                    nextKey = if (endOfPaginationReached) null else currentPage + 1
                )
            } else {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }
        } catch (e: Exception) {
            Log.d("paging_test", "load: " + e)
            LoadResult.Error(e)
        }
    }


}