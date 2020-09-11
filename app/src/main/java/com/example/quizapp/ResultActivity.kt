package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.quizapp.history.TestResult
import com.example.quizapp.history.TestResultViewModel
import kotlinx.android.synthetic.main.activity_result.*
import java.text.SimpleDateFormat
import java.util.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val username = intent.getStringExtra(Constants.USER_NAME)
        name_textView.text = username

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        score_textView.text = "Your score is $correctAnswers out of $totalQuestions"

        val date: String = SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault()).format(Date())

        finish_btn.setOnClickListener {
            val testResultViewModel = ViewModelProvider(this).get(TestResultViewModel::class.java)
            val testResult = username?.let { it1 -> TestResult(0, it1, correctAnswers, date) }
            if (testResult != null) {
                testResultViewModel.insert(testResult)
            }
            Toast.makeText(this, "Quiz results added to history", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}