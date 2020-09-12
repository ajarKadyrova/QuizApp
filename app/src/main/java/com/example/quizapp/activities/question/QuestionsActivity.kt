package com.example.quizapp.activities.question

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.quizapp.R
import com.example.quizapp.activities.ResultActivity
import com.example.quizapp.model.Question
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers : Int = 0
    private var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mQuestionsList = Constants.getQuestions()
        setQuestionView()

        option_one_textView.setOnClickListener(this)
        option_two_textView.setOnClickListener(this)
        option_three_textView.setOnClickListener(this)
        option_four_textView.setOnClickListener(this)
        submin_btn.setOnClickListener(this)
    }

    private fun setQuestionView() {
        val question = mQuestionsList!!.get(mCurrentPosition - 1)

        defaultOptionsView()

        if(mCurrentPosition == mQuestionsList!!.size){
            submin_btn.text = "Finish"
        } else {
            submin_btn.text = "Submit"
        }

        progress_bar.progress = mCurrentPosition
        progress_bar.max = mQuestionsList!!.size
        progress_textView.text = "$mCurrentPosition" + "/" + progress_bar.max
        question_textView.text = question!!.question
        image_ImageView.setImageResource(question.image)
        option_one_textView.text = question.optionOne
        option_two_textView.text = question.optionTwo
        option_three_textView.text = question.optionThree
        option_four_textView.text = question.optionFour
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0, option_one_textView)
        options.add(1, option_two_textView)
        options.add(2, option_three_textView)
        options.add(3, option_four_textView)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,
                R.drawable.default_option_border
            )
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.option_one_textView -> {
                selectedOptionView(option_one_textView, 1)
            }
            R.id.option_two_textView -> {
                selectedOptionView(option_two_textView, 2)
            }
            R.id.option_three_textView -> {
                selectedOptionView(option_three_textView, 3)
            }
            R.id.option_four_textView -> {
                selectedOptionView(option_four_textView, 4)
            }
            R.id.submin_btn -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestionView()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,
                            R.drawable.wrong_option_border
                        )
                    } else {
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer,
                        R.drawable.correct_option_border
                    )
                    if(mCurrentPosition == mQuestionsList!!.size){
                        submin_btn.text = "Finish"
                    } else {
                        submin_btn.text = "Go to next question"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                option_one_textView.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                option_two_textView.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                option_three_textView.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 -> {
                option_four_textView.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }

    private fun selectedOptionView(textView: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(this,
            R.drawable.selected_option_border
        )

    }
}