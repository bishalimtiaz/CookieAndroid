package com.cookieTech.cookieandroid.Architecture.di

import com.cookieTech.cookieandroid.Data.repositories.DataSource.FoodRemoteDataSource
import com.cookieTech.cookieandroid.Data.repositories.DataSourceImpl.FoodRemoteDataSourceImpl
import com.cookieTech.cookieandroid.data.remote.FoodApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

    @Provides
    @Singleton
    fun provideFoodRemoteDataSource(foodApi: FoodApi): FoodRemoteDataSource {
        return FoodRemoteDataSourceImpl(foodApi)
    }
}