package com.example.quizapp.activities.question

import com.example.quizapp.R
import com.example.quizapp.model.Question

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1, "Who's founder of Neobis?",
            R.drawable.ic_launcher_background,
            "Don't know",
            "You",
            "Me",
            "Sanira",
            4
        )
        questionsList.add(que1)

        val que2 = Question(
            1,
            "How many flows of students Neobis had so far?",
            R.drawable.ic_launcher_background,
            "150",
            "11",
            "5",
            "Don't know",
            2
        )
        questionsList.add(que2)

        val que3 = Question(
            1, "Which department is the best?",
            R.drawable.ic_launcher_background,
            "Android",
            "UI/UX",
            "Backend",
            "All departments",
            4
        )
        questionsList.add(que3)

        val que4 = Question(
            1,
            "Who's the head of the club?",
            R.drawable.ic_launcher_background,
            "Sanira",
            "Aisalkyn",
            "Nodir",
            "Don't know",
            3
        )
        questionsList.add(que4)

        val que5 = Question(
            1,
            "What's the name of developer of this app?",
            R.drawable.ic_launcher_background,
            "Ajar",
            "Aisuluu",
            "Ramzan",
            "Bogdan",
            1
        )
        questionsList.add(que5)

        return questionsList
    }
}