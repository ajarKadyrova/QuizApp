package com.example.quizapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.quizapp.fragments.QuizFragment
import com.example.quizapp.R
import com.example.quizapp.fragments.history.HistoryFragment
import com.example.quizapp.viewModel.TestResultViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var quizFragment: QuizFragment
    lateinit var historyFragment: HistoryFragment
    private lateinit var testResultViewModel: TestResultViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navBar: BottomNavigationView = findViewById(R.id.nav_bar)
            quizFragment = QuizFragment()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, quizFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()

        navBar.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_quiz -> {
                    quizFragment = QuizFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, quizFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.nav_history -> {
                    historyFragment =
                        HistoryFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, historyFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
            }
            true
        }
    }
}