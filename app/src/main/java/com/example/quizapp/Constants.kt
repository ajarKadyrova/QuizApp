package com.example.quizapp

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val que1 = Question(1, "Who's founder of Neobis?",
            R.drawable.ic_launcher_background,
            "Don't know",
            "You",
            "Me",
            "Sanira",
            4 )
        questionsList.add(que1)

        val que2 = Question(1,
            "Who's founder of Neobis?",
            R.drawable.ic_launcher_background,
            "Sanira",
            "You",
            "Me",
            "Don't know",
            1 )
        questionsList.add(que2)

        val que3 = Question(1, "Who's founder of Neobis?",
            R.drawable.ic_launcher_background,
            "Don't know",
            "You",
            "Me",
            "Sanira",
            4 )
        questionsList.add(que3)

        val que4 = Question(1,
            "Who's founder of Neobis?",
            R.drawable.ic_launcher_background,
            "Sanira",
            "You",
            "Me",
            "Don't know",
            1 )
        questionsList.add(que4)

        return questionsList
    }
}