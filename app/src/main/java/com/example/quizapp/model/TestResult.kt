package com.example.quizapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "test_results_table")
data class TestResult(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "username")
    val username: String?,

    @ColumnInfo(name = "score")
    val score: String,

    @ColumnInfo(name = "date")
    val date: String
)