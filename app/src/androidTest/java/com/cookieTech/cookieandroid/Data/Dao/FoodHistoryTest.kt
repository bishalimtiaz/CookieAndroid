package com.cookieTech.cookieandroid.Data.Dao

import android.content.Context
import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.cookieTech.cookieandroid.Data.Database.AppDatabase
import com.cookieTech.cookieandroid.domain.models.Food
import com.cookieTech.cookieandroid.domain.models.FoodHistory
import com.cookieTech.cookieandroid.domain.models.FoodHistoryAndFood
import com.cookieTech.cookieandroid.MealType
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.hamcrest.Matchers
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*


@RunWith(AndroidJUnit4::class)
class FoodHistoryTest {

    lateinit var appDatabase: AppDatabase
    lateinit var context: Context
    lateinit var foodDao: FoodDao
    lateinit var foodHistoryDao: FoodHistoryDao
    private val cal = Calendar.getInstance().apply {
        set(Calendar.YEAR, 2022)
        set(Calendar.MONTH, Calendar.MARCH)
        set(Calendar.DAY_OF_MONTH, 10)
    }

    private val cal1 = Calendar.getInstance().apply {
        set(Calendar.YEAR, 2022)
        set(Calendar.MONTH, Calendar.MARCH)
        set(Calendar.DAY_OF_MONTH, 11)
    }
    val food = Food("Green Beans",100f,3,0.2f,2f,6f,4f,2f,33f)

    val food1 = Food("Broccoli, Raw",100f,3,0.4f,2.8f,6.6f,2.6f,4f,42f)
    val food2 = Food("Spinach, Raw",100f,3,0.4f,2.9f,3.6f,2.2f,1.4f,30f)
    val food3 = Food("Green Leaf Lettuce Leaves",100f,3,0.1f,0.9f,3f,1.2f,1.8f,16f)

    val foodHistory = FoodHistory(foodId = 1,date = cal,mealType = MealType[0],1f,2)
    val foodHistory1 = FoodHistory(foodId = 2,date = cal,mealType = MealType[0],1f,2)
    val foodHistory2 = FoodHistory(foodId = 3,date = cal,mealType = MealType[1],1f,2)
    val foodHistory3 = FoodHistory(foodId = 4,date = cal1,mealType = MealType[1],1f,2)
    val foodHistory4 = FoodHistory(foodId = 2,date = cal1,mealType = MealType[1],1f,2)
    val foodHistory5 = FoodHistory(foodId = 3,date = cal1,mealType = MealType[2],1f,2)

    val initialFoods = listOf(food,food1,food2,food3)
    val initialFoodHistories = listOf(foodHistory,foodHistory1,foodHistory2,foodHistory3)


    //A JUnit Test Rule that swaps the background executor used by the Architecture Components with a different one which executes each task synchronously.
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun before(){
        context = InstrumentationRegistry.getInstrumentation().targetContext
        appDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        foodDao = appDatabase.foodDao
        foodHistoryDao = appDatabase.foodHistoryDao

        var ids = foodDao.insert(initialFoods)
        for(id in ids.withIndex()){
            initialFoods[id.index].id = id.value
        }
        ids =  foodHistoryDao.insert(initialFoodHistories)
        for(id in ids.withIndex()){
            initialFoodHistories[id.index].id = id.value
        }
    }

    @After
    fun after(){
        appDatabase.close()
    }


    @Test
    fun getAllFoodHistory() = runBlocking{
        val allFoodHistory = foodHistoryDao.getAllFoodHistory().first()

        ViewMatchers.assertThat(allFoodHistory.size, Matchers.equalTo(4))

        ViewMatchers.assertThat(allFoodHistory[0], Matchers.equalTo(foodHistory))
        ViewMatchers.assertThat(allFoodHistory[1], Matchers.equalTo(foodHistory1))
        ViewMatchers.assertThat(allFoodHistory[2], Matchers.equalTo(foodHistory2))
        ViewMatchers.assertThat(allFoodHistory[3], Matchers.equalTo(foodHistory3))
    }


    @Test
    fun getFoodHistoryById()= runBlocking{
        val result = foodHistoryDao.getFoodHistoryById(1).first()
        ViewMatchers.assertThat(result, Matchers.equalTo(FoodHistoryAndFood(foodHistory,food)))
    }

    @Test
    fun getFoodHistoryByDate()= runBlocking{
        val allFoodHistory = foodHistoryDao.getAllFoodHistoryByDate(cal).first()

        ViewMatchers.assertThat(allFoodHistory.size, Matchers.equalTo(3))

        ViewMatchers.assertThat(allFoodHistory[0], Matchers.equalTo(FoodHistoryAndFood(foodHistory,food)))
        ViewMatchers.assertThat(allFoodHistory[1], Matchers.equalTo(FoodHistoryAndFood(foodHistory1,food1)))
        ViewMatchers.assertThat(allFoodHistory[2], Matchers.equalTo(FoodHistoryAndFood(foodHistory2,food2)))
    }

    @Test
    fun getFoodHistoryByDateAndMealType() = runBlocking {
        val allFoodHistory = foodHistoryDao.getFoodHistoryByDateAndMealType(cal, MealType[0]).first()

        ViewMatchers.assertThat(allFoodHistory.size, Matchers.equalTo(2))

        ViewMatchers.assertThat(allFoodHistory[0], Matchers.equalTo(FoodHistoryAndFood(foodHistory,food)))
        ViewMatchers.assertThat(allFoodHistory[1], Matchers.equalTo(FoodHistoryAndFood(foodHistory1,food1)))
    }


    @Test
    fun addFoodHistory() = runBlocking{
        val result = foodHistoryDao.insert(foodHistory4)
        foodHistory4.id = result
        Log.d("result", "addFood: $result")
        val newFoodHistory = foodHistoryDao.getFoodHistoryById(result).first()
        ViewMatchers.assertThat(newFoodHistory, Matchers.equalTo(FoodHistoryAndFood(foodHistory4,food1)))

        val result1 = foodHistoryDao.insert(foodHistory4)
        Log.d("result", "addFood: $result1")
        ViewMatchers.assertThat(result1, Matchers.equalTo(-1))
    }


    @Test
    fun updateFoodHistory() = runBlocking{
        val newFoodHistory = foodHistory.copy(foodId = 3)
        newFoodHistory.id = 1
        val result = foodHistoryDao.update(newFoodHistory)
        Log.d("result", "addFood: $result")
        ViewMatchers.assertThat(result, Matchers.equalTo(1))
        ViewMatchers.assertThat(foodHistoryDao.getFoodHistoryById(1).first(), Matchers.equalTo(FoodHistoryAndFood(newFoodHistory,food2)))

        val newFoodHistory1 = foodHistory1.copy(foodId = 4)
        newFoodHistory1.id = 2
        val newFoodHistory2 = foodHistory2.copy(mealType = MealType[0])
        newFoodHistory2.id = 3

        val result1 = foodHistoryDao.update(listOf(newFoodHistory1,newFoodHistory2))
        Log.d("result", "addFood: $result1")
        ViewMatchers.assertThat(result1, Matchers.equalTo(2))


    }


    @Test
    fun deleteFoodHistory() = runBlocking{
        val result = foodHistoryDao.delete(foodHistory)
        val allFoods = foodHistoryDao.getAllFoodHistory().first()
        Log.d("result", "addFood: $result $allFoods")
        ViewMatchers.assertThat(result, Matchers.equalTo(1))
        ViewMatchers.assertThat(allFoods.size, Matchers.equalTo(initialFoodHistories.size-1))

        val result1 = foodHistoryDao.delete(foodHistory)
        val allFoods1 = foodHistoryDao.getAllFoodHistory().first()
        Log.d("result", "addFood: $result1")
        ViewMatchers.assertThat(result1, Matchers.equalTo(0))
        ViewMatchers.assertThat(allFoods1.size, Matchers.equalTo(allFoods.size))
    }

    @Test
    fun upsertFood() = runBlocking{
        val result = foodHistoryDao.upsert(foodHistory5)
        foodHistory5.id = 5
        Log.d("result", "addFood: $result")
        val newFoodHistory = foodHistoryDao.getFoodHistoryById(result).first()
        ViewMatchers.assertThat(newFoodHistory, Matchers.equalTo(FoodHistoryAndFood(foodHistory5,food2)))



        val copy = foodHistory5.copy(foodId = 1)
        copy.id = 4
        val result1 = foodHistoryDao.upsert(copy)
        Log.d("result", "addFood: $result1")
        ViewMatchers.assertThat(result1,Matchers.equalTo(1))
        val newFood1 = foodHistoryDao.getFoodHistoryById(4).first()
        ViewMatchers.assertThat(newFood1, Matchers.equalTo(FoodHistoryAndFood(copy,food)))

    }


}