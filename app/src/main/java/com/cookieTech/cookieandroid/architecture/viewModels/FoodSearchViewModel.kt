package com.cookieTech.cookieandroid.architecture.viewModels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import com.cookieTech.cookieandroid.domain.models.SearchFoodItem
import com.cookieTech.cookieandroid.domain.repositories.FoodRepository
import com.cookieTech.cookieandroid.domain.useCases.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.ObservableSource
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@ExperimentalPagingApi
@HiltViewModel
class FoodSearchViewModel @Inject constructor(

    private val searchUseCase: SearchUseCase
) : ViewModel() {

    private val _searchData = MutableLiveData<List<SearchFoodItem>>()
    private val searchData:LiveData<List<SearchFoodItem>> = _searchData



    val searchSubject = PublishSubject.create<String>()



    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery

    @OptIn(ExperimentalCoroutinesApi::class)
    val searchResult = searchQuery.debounce(1000)
        .distinctUntilChanged()
        .filter {
            if (it.isEmpty()) {
                _searchData.postValue(listOf())
                false;
            } else {
                true;
            }
        }
        .flowOn(Dispatchers.IO)
        .flatMapLatest {
            queryFromDb(it)
        }

    private suspend fun queryFromDb(query: String) : Flow<PagingData<SearchFoodItem>> {
        return searchUseCase.searchFood(query = query)
    }

    /*private val _searchedFoods = MutableStateFlow<PagingData<Food>>(PagingData.empty())
    val searchedFoods = _searchedFoods*/

    fun updateSearchQuery(query: String) {
        Log.d("search_test", "updateSearchQuery: " + query)
        _searchQuery.value = query
    }

    fun clearSearchQuery(){
        _searchQuery.value = ""
    }

    fun searchFoods(query: String) {
        viewModelScope.launch {
            /*repository.searchAllFoods(query = query).cachedIn(viewModelScope).collect {
                _searchedFoods.value = it
            }*/
        }
    }

    fun addFoodToHistory(item: SearchFoodItem) {
        viewModelScope.launch(Dispatchers.IO) {
            searchUseCase.addFoodToHistory(item)
        }
    }

    init {




    }

}