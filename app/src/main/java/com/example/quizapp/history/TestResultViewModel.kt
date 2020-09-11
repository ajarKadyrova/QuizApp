package com.example.quizapp.history

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.quizapp.data.AppDatabase
import com.example.quizapp.data.TestResultRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TestResultViewModel(application: Application) : AndroidViewModel(application) {

    val getAllData: LiveData<List<TestResult>>
    private val repository: TestResultRepository

    init {
        val testResultDao = AppDatabase.getInstance(application).testResultDao()
        repository = TestResultRepository(testResultDao)
        getAllData = repository.getAllItems
    }

    fun insert(testResult: TestResult){
        viewModelScope.launch(Dispatchers.IO){
            repository.insert(testResult)
        }
    }

    fun deleteAllItems(){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAllItems()
        }
    }
}