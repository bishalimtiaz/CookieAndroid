package com.cookieTech.cookieandroid.Data.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.cookieTech.cookieandroid.Data.Converters.Converters
import com.cookieTech.cookieandroid.Data.Dao.FoodDao
import com.cookieTech.cookieandroid.Data.Dao.FoodHistoryDao
import com.cookieTech.cookieandroid.Data.Dao.UnitsDao
import com.cookieTech.cookieandroid.Data.Workers.PrepopulateDbWorker
import com.cookieTech.cookieandroid.Data.Workers.PrepopulateDbWorker.Companion.KEY_FILENAME
import com.cookieTech.cookieandroid.domain.models.*
import com.cookieTech.cookieandroid.UNIT_DATA_FILENAME


@Database(
    entities = [
        Food::class,
        FoodHistory::class,
        Minerals::class,
        Vitamins::class,
        Units::class,
        FoodFts::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {
    abstract val foodDao:FoodDao
    abstract val foodHistoryDao:FoodHistoryDao
    abstract val unitsDao:UnitsDao

    companion object{

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this){
                var instance = INSTANCE
                if(instance == null)
                {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "lose_to_gain_database"
                    )
                        .addCallback(DatabaseCreationCallback(context))
                        .fallbackToDestructiveMigration() // if migrate the data will be lost . need to implement differently
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }

        private class DatabaseCreationCallback(val context: Context): RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                val prepopulateRequest = OneTimeWorkRequestBuilder<PrepopulateDbWorker>()
                    .setInputData(workDataOf(KEY_FILENAME to UNIT_DATA_FILENAME))
                    .build();
                WorkManager.getInstance(context).enqueue(prepopulateRequest)

                db.execSQL("INSERT INTO food_fts(food_fts) VALUES ('rebuild')")
            }
        }
    }


}