package com.example.quizapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.quizapp.history.HistoryFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var quizFragment: QuizFragment
    lateinit var historyFragment: HistoryFragment

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
                R.id. nav_quiz-> {
                    quizFragment = QuizFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, quizFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id. nav_history-> {
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