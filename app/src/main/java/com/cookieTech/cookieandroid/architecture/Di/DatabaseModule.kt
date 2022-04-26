package com.cookieTech.cookieandroid.Architecture.di

import android.app.Application
import com.cookieTech.cookieandroid.Data.Dao.FoodDao
import com.cookieTech.cookieandroid.Data.Database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideDatabase(app: Application): AppDatabase =
        AppDatabase.getInstance(app)

    @Provides
    fun provideFoodDao(appDatabase: AppDatabase) : FoodDao= appDatabase.foodDao

}