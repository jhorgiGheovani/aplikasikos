package com.eduproject.pmob

import android.app.Application
import com.eduproject.pmob.data.MainRepository
import com.eduproject.pmob.data.room.MainDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class MyApplication: Application() {
    private val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { MainDatabase.getInstance(this, applicationScope) }
    val repository by lazy { MainRepository(database.mainDao()) }

}