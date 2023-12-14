package com.eduproject.pmob.data

import androidx.lifecycle.LiveData
import com.eduproject.pmob.data.entity.MainEntity
import com.eduproject.pmob.data.room.MainDAO

class MainRepository(private val mainDAO: MainDAO) {

    fun listKosan(): LiveData<List<MainEntity>> = mainDAO.getData()
}