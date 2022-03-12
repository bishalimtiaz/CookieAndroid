package com.cookieTech.cookieandroid.Data.Dao

import android.content.Context
import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.cookieTech.cookieandroid.Data.Database.AppDatabase
import com.cookieTech.cookieandroid.Domain.Models.Food
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.hamcrest.Matchers
import org.junit.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)

class FoodDaoTest {
    lateinit var appDatabase: AppDatabase
    lateinit var context: Context
    lateinit var foodDao: FoodDao
    val food = Food("Green Beans",100f,3,0.2f,2f,6f,4f,2f,33f)

    val food1 = Food("Broccoli, Raw",100f,3,0.4f,2.8f,6.6f,2.6f,4f,42f)
    val food2 = Food("Spinach, Raw",100f,3,0.4f,2.9f,3.6f,2.2f,1.4f,30f)
    val food3 = Food("Green Leaf Lettuce Leaves",100f,3,0.1f,0.9f,3f,1.2f,1.8f,16f)

    //A JUnit Test Rule that swaps the background executor used by the Architecture Components with a different one which executes each task synchronously.
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun before(){
        context = InstrumentationRegistry.getInstrumentation().targetContext
        appDatabase = Room.inMemoryDatabaseBuilder(context,AppDatabase::class.java).build()
        foodDao = appDatabase.foodDao

        foodDao.insert(listOf(food1,food2,food3))
    }

    @After
    fun after(){
        appDatabase.close()
    }


    @Test
    fun getAllFoods() = runBlocking{
        val allFoods = foodDao.getAllFood().first()

        assertThat(allFoods.size, Matchers.equalTo(3))

        assertThat(allFoods[0],Matchers.equalTo(food1))
        assertThat(allFoods[1],Matchers.equalTo(food2))
        assertThat(allFoods[2],Matchers.equalTo(food3))
    }


    @Test
    fun getFoodById()= runBlocking{
        val food = foodDao.getFoodById(1).first()
        assertThat(food,Matchers.equalTo(food1))
    }


    @Test
    fun addFood() = runBlocking{
        val result = foodDao.insert(food)
        Log.d("result", "addFood: $result")
        val newFood = foodDao.getFoodById(result).first()
        assertThat(newFood,Matchers.equalTo(food))

        food1.id = 1
        val result1 = foodDao.insert(food1)
        Log.d("result", "addFood: $result1")
        assertThat(result1,Matchers.equalTo(-1))
    }


    @Test
    fun updateFood(){
        food.id = 2
        val result = foodDao.update(food)
        Log.d("result", "addFood: $result")
        assertThat(result, Matchers.equalTo(1))

        val newFood1 = food.copy()
        val newFood2 = food.copy()

        newFood1.id = 1
        newFood2.id = 2

        val result1 = foodDao.update(listOf(newFood1,newFood2))
        Log.d("result", "addFood: $result1")
        assertThat(result1, Matchers.equalTo(2))
    }


    @Test
    fun deleteFood() = runBlocking{
        food1.id = 1
        val result = foodDao.delete(food1)
        val allFoods = foodDao.getAllFood().first()
        Log.d("result", "addFood: $result")
        assertThat(result, Matchers.equalTo(1))
        assertThat(allFoods.size, Matchers.equalTo(2))

        val result1 = foodDao.delete(food)
        val allFoods1 = foodDao.getAllFood().first()
        Log.d("result", "addFood: $result1")
        assertThat(result1, Matchers.equalTo(0))
        assertThat(allFoods1.size, Matchers.equalTo(2))
    }

    @Test
    fun upsertFood() = runBlocking{
        val result = foodDao.upsert(food)
        Log.d("result", "addFood: $result")
        val newFood = foodDao.getFoodById(result).first()
        assertThat(newFood, Matchers.equalTo(food))



        food.id = 1
        val result1 = foodDao.upsert(food)
        Log.d("result", "addFood: $result1")
        val newFood1 = foodDao.getFoodById(result1).first()
        assertThat(newFood1, Matchers.equalTo(food))

    }


    @Test
    fun searchFood() = runBlocking {
        val result = foodDao.searchFoodMinimal("*gr*").first()
        Log.d("result", "searchFood: $result")

        assertThat(result.size, Matchers.equalTo(1))
    }

}