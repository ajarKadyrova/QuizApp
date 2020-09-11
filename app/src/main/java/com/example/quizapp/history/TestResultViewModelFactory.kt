package com.example.quizapp.history

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.quizapp.data.TestResultDao
import java.lang.IllegalArgumentException

class TestResultViewModelFactory(
    private val dataSource:TestResultDao,
    private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>) : T{
        if(modelClass.isAssignableFrom(TestResultViewModelFactory::class.java)){
            return TestResultViewModelFactory(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}