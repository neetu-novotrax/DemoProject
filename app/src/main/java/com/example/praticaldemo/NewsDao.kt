package com.example.praticaldemo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.praticaldemo.data.Data


/**
 * Created by Waheed on 04,November,2019
 */

/**
 * Abstracts access to the news database
 */
@Dao
interface NewsDao {

    /**
     * Insert articles into the database
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(articles: Data?): List<Long>

    /**
     * Get all the articles from database
     */
    @Query("SELECT * FROM news_table")
    fun getData(): LiveData<List<Data>>

    @Query("DELETE FROM news_table")
    abstract fun deleteAllArticles()
}