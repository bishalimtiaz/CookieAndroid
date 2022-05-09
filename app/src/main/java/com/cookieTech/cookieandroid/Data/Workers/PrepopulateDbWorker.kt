package com.cookieTech.cookieandroid.Data.Workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.cookieTech.cookieandroid.Data.Database.AppDatabase
import com.cookieTech.cookieandroid.domain.models.Units
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception


/***
 * https://developer.android.com/topic/libraries/architecture/workmanager?gclid=Cj0KCQiA95aRBhCsARIsAC2xvfw6l8Zey2I_GTa7u6bEew-f8wQicYFNjkkJqWiroT_-x3TzsYTQavIaAj5PEALw_wcB&gclsrc=aw.ds
 * three types of persistent work
 * Immediate - begin immediately and complete soon :  and
 *          Expedited -
 * Long Running - Run for longer ( 10min+) : WorkRequest and Worker
 *          setForeground() : for handle notification
 * Deferrable - scheduled task for later and periodic : PeriodicWorkRequest and Worker
 *
 * other benefits:
 *      Work constraints - Define when to run the task
 *      Robust scheduling - schedule unique ,replaceable work , monitor and cancel groups of work.
 *                          scheduled works are managed in SQLite database and WorkManager takes care of
 *                          persists and rescheduling . Power saving features like Doze mode
 *      Expedited Work - Expedited work for important tasks to complete within few minutes
 *      Flexible retry policy - offers flexible retry policy including configurable exponential backoff
 *                              policy
 *      Work chaining - chain individual work tasks together that which run sequentially and which run
 *                      parallel
 *      Build-in threading interoperability - Sync with Coroutines and RxJava
 */





class PrepopulateDbWorker(
    context: Context,
    params: WorkerParameters
): CoroutineWorker(context,params) {
    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
            val filename = inputData.getString(KEY_FILENAME)
            if (filename != null) {
                applicationContext.assets.open(filename).use { inputStream ->
                    JsonReader(inputStream.reader()).use { jsonReader ->

                        val unitType = object : TypeToken<List<Units>>() {}.type
                        val unitList: List<Units> = Gson().fromJson(jsonReader, unitType)

                        val database = AppDatabase.getInstance(applicationContext)
                        database.unitsDao.insert(unitList)

                        Result.success()
                    }
                }
            } else {
                Log.e(TAG, "Error seeding database - no valid filename")
                Result.failure()
            }
        } catch (ex: Exception) {
            Log.e(TAG, "Error seeding database", ex)
            Result.failure()
        }
    }


    companion object {
        private const val TAG = "PrepopulateDbWorker"
        const val KEY_FILENAME = "UNIT_DATA_FILENAME"
    }
}