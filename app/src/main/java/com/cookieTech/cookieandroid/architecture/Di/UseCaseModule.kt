package com.cookieTech.cookieandroid.Architecture.di

import com.cookieTech.cookieandroid.Data.Repositories.FoodRepositoryImpl
import com.cookieTech.cookieandroid.Data.repositories.DataSource.FoodRemoteDataSource
import com.cookieTech.cookieandroid.domain.repositories.FoodRepository
import com.cookieTech.cookieandroid.domain.useCases.SearchUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideSearchUseCase(
        foodRepository: FoodRepository
    ): SearchUseCase =
        SearchUseCase(foodRepository)
}