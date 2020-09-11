package com.example.quizapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.quizapp.history.TestResult

@Dao
interface TestResultDao {

    @Insert
    fun insert(testResult: TestResult)

    @Query("SELECT * FROM test_results_table ")
    fun getAllItems(): LiveData<List<TestResult>>

    @Query("DELETE FROM test_results_table")
    fun deleteAll()
}