package com.example.quizapp.data

import androidx.lifecycle.LiveData
import com.example.quizapp.history.TestResult

class TestResultRepository(private val testResultDao: TestResultDao) {

    val getAllItems: LiveData<List<TestResult>> = testResultDao.getAllItems()

    suspend fun insert(testResult: TestResult){
        testResultDao.insert(testResult)
    }

    suspend fun deleteAllItems(){
        testResultDao.deleteAll()
    }
}