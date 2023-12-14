package com.eduproject.pmob

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eduproject.pmob.data.MainRepository
import com.eduproject.pmob.data.entity.MainEntity

class MainViewModel(private val mainRepository: MainRepository):ViewModel() {

fun getKosan():LiveData<List<MainEntity>> = mainRepository.listKosan()
}
class ViewModelFactory(private val repository: MainRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}