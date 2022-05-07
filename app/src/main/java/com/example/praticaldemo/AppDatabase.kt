package com.example.praticaldemo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.praticaldemo.data.Data


/**
 * Created by Waheed on 04,November,2019
 */

/**
 * App Database
 * Define all entities and access doa's here/ Each entity is a table.
 */
@Database(entities = [Data::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    val DB_NAME = "database-name"
    private var INSTANCE: AppDatabase? = null
    abstract fun demoDataDao(): NewsDao

     fun getInstance(context: Context): AppDatabase? {
        if (INSTANCE == null) {
            synchronized(AppDatabase::class.java) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, DB_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
        }
        return INSTANCE
    }


}