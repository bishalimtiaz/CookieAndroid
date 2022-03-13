package com.cookieTech.cookieandroid.modules.search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import com.cookieTech.cookieandroid.data.repositories.FoodSearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalPagingApi
@HiltViewModel
class FoodSearchViewModel @Inject constructor(
    private val repository: FoodSearchRepository
) : ViewModel() {

    private val _searchQuery = mutableStateOf("")
    val searchQuery = _searchQuery

    /*private val _searchedFoods = MutableStateFlow<PagingData<Food>>(PagingData.empty())
    val searchedFoods = _searchedFoods*/

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun searchFoods(query: String) {
        viewModelScope.launch {
            /*repository.searchAllFoods(query = query).cachedIn(viewModelScope).collect {
                _searchedFoods.value = it
            }*/
        }
    }

}