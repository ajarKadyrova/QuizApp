package com.example.quizapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.quizapp.activities.question.Constants
import com.example.quizapp.R
import com.example.quizapp.activities.question.QuestionsActivity
import kotlinx.android.synthetic.main.fragment_quiz.*

class QuizFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        start_btn.setOnClickListener{
            if (name_editText.text.toString().isEmpty()){
                Toast.makeText(
                    context, "Please enter your name",
                    Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(context, QuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, name_editText.text.toString())
                startActivity(intent)
            }
        }
    }
}