package com.eduproject.pmob.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.eduproject.pmob.data.entity.MainEntity

@Dao
interface  MainDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(data: List<MainEntity>)


    @Query("SELECT * FROM kosan")
    fun getData(): LiveData<List<MainEntity>>
}