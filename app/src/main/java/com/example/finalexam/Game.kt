package com.example.finalexam

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat


class Game : AppCompatActivity(), View.OnClickListener {

    private lateinit var iv_image: ImageView
    private lateinit var ll_progress_details: LinearLayout
    private lateinit var progressBar: ProgressBar
    private lateinit var tv_progress: TextView
    private lateinit var tv_option_one: TextView
    private lateinit var tv_option_two: TextView
    private lateinit var tv_option_three: TextView
    private lateinit var tv_option_four: TextView
    private lateinit var tv_option_five: TextView
    private lateinit var tv_option_six: TextView
    private lateinit var btn_submit: Button
    private lateinit var tv_question: TextView
    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Questions>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)


        iv_image = findViewById(R.id.iv_image)
        ll_progress_details = findViewById(R.id.ll_progress_details)
        progressBar = findViewById(R.id.progressBar)
        tv_progress = findViewById(R.id.tv_progress)
        tv_option_one = findViewById(R.id.tv_option_one)
        tv_option_two = findViewById(R.id.tv_option_two)
        tv_option_three = findViewById(R.id.tv_option_three)
        tv_option_four = findViewById(R.id.tv_option_four)
        tv_option_five = findViewById(R.id.tv_option_five)
        tv_option_six = findViewById(R.id.tv_option_six)
        btn_submit = findViewById(R.id.btn_submit)
        tv_question = findViewById(R.id.tv_question)


        mQuestionsList = Constans.getQuestion()

        setQuestion()
        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        tv_option_five.setOnClickListener(this)
        tv_option_six.setOnClickListener(this)
        btn_submit.setOnClickListener(this)

    }

    private fun setQuestion() {

        val question = mQuestionsList!![mCurrentPosition - 1]


        if (mCurrentPosition == mQuestionsList!!.size) {
            btn_submit.text = "FINISH"
        } else {
            btn_submit.text = "SUBMIT"
        }

        defaultOptionsView()

        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.max
        tv_question.text = question!!.question
        iv_image.setImageResource(question.image)
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour
        tv_option_five.text = question.optionFive
        tv_option_six.text = question.optionSix
    }

    private fun defaultOptionsView() {
        val option = ArrayList<TextView>()
        option.add(0, tv_option_one)
        option.add(1, tv_option_two)
        option.add(2, tv_option_three)
        option.add(3, tv_option_four)
        option.add(4, tv_option_five)
        option.add(5, tv_option_six)

        for (option in option) {
            option.setTextColor(Color.parseColor("#0000cd"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                    this, R.drawable.default_option_border_bg)
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 ->
                tv_option_one.background = ContextCompat.getDrawable(
                        this, drawableView
                )
            2 ->
                tv_option_two.background = ContextCompat.getDrawable(
                        this, drawableView
                )
            3 ->
                tv_option_three.background = ContextCompat.getDrawable(
                        this, drawableView
                )
            4 ->
                tv_option_four.background = ContextCompat.getDrawable(
                        this, drawableView
                )
            5 ->
                tv_option_five.background = ContextCompat.getDrawable(
                        this, drawableView
                )
            6 ->
                tv_option_six.background = ContextCompat.getDrawable(
                        this, drawableView
                )

        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_option_one -> {
                selectedOptionView(tv_option_one, 1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(tv_option_two, 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(tv_option_three, 3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(tv_option_four, 4)
            }
            R.id.tv_option_five -> {
                selectedOptionView(tv_option_five, 5)
            }
            R.id.tv_option_six -> {
                selectedOptionView(tv_option_six, 6)
            }
            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constans.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constans.TOTAL_QUESTIONS, mQuestionsList!!.size)
                            startActivity(intent)

                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    } else {
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionsList!!.size) {
                        btn_submit.text = "FINISH"
                    } else {
                        btn_submit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition == 0
                }
            }
        }
    }

    private fun selectedOptionView(tv:TextView, selectedOptionNum: Int){

        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
                this, R.drawable.selected_option_border_bg)

    }

}