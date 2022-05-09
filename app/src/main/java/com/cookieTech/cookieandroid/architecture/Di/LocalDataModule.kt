package com.cookieTech.cookieandroid.Architecture.di

import com.cookieTech.cookieandroid.Data.Dao.FoodDao
import com.cookieTech.cookieandroid.Data.Repositories.DataSource.FoodLocalDataSource
import com.cookieTech.cookieandroid.Data.Repositories.DataSourceImpl.FoodLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    @Provides
    fun provideFoodLocalDataSource(foodDao: FoodDao): FoodLocalDataSource =
        FoodLocalDataSourceImpl(foodDao)
}