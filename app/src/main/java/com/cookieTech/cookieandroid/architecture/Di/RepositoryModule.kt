package com.cookieTech.cookieandroid.Architecture.di

import com.cookieTech.cookieandroid.Data.Repositories.DataSource.FoodLocalDataSource
import com.cookieTech.cookieandroid.Data.Repositories.FoodRepositoryImpl
import com.cookieTech.cookieandroid.Data.repositories.DataSource.FoodRemoteDataSource
import com.cookieTech.cookieandroid.domain.repositories.FoodRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideFoodRepository(
        foodRemoteDataSource: FoodRemoteDataSource,
        foodLocalDataSource: FoodLocalDataSource
    ): FoodRepository =
        FoodRepositoryImpl(foodRemoteDataSource,foodLocalDataSource)

}