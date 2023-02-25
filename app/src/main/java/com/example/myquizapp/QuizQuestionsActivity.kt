package com.example.myquizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private var mUserName: String? = null
    private var mCorrectAnswers: Int = 0
    private var mCurrentPosition: Int = 0
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var tvQuestion: TextView? = null
    private var progressBar: ProgressBar? = null
    private var progressBarTextView: TextView? = null
    private var flagImageView: ImageView? = null
    private var optionOneTextView: TextView? = null
    private var optionTwoTextView: TextView? = null
    private var optionThreeTextView: TextView? = null
    private var optionFourTextView: TextView? = null
    private var submitBtn: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quic_questions)
        mUserName = intent.getStringExtra(Constants.USER_NAME)
        tvQuestion = findViewById(R.id.tv_question)
        progressBar = findViewById(R.id.progressBar)
        progressBarTextView = findViewById(R.id.progressTextView)
        flagImageView = findViewById(R.id.flagImageView)
        optionOneTextView = findViewById(R.id.optionOneTextView)
        optionTwoTextView = findViewById(R.id.optionTwoTextView)
        optionThreeTextView = findViewById(R.id.optionThreeTextView)
        optionFourTextView = findViewById(R.id.optionFourTextView)
        submitBtn = findViewById(R.id.submitBtn)
        optionOneTextView?.setOnClickListener(this)
        optionTwoTextView?.setOnClickListener(this)
        optionThreeTextView?.setOnClickListener(this)
        optionFourTextView?.setOnClickListener(this)
        submitBtn?.setOnClickListener(this)
        mQuestionsList = Constants.getQuestions()
        setQuestion()
    }

    private fun setQuestion() {
        defaultOptionsView()
        val question: Question = mQuestionsList!![mCurrentPosition]
        tvQuestion?.text = question.question
        flagImageView?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition + 1
        progressBarTextView?.text = "${mCurrentPosition + 1} / ${progressBar?.max}"
        optionOneTextView?.text = question.optionOne
        optionTwoTextView?.text = question.optionTwo
        optionThreeTextView?.text = question.optionThree
        optionFourTextView?.text = question.optionFour
//        if (mCurrentPosition == mQuestionsList!!.size - 1) {
//            submitBtn!!.text = "Finish"
//        }
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        optionOneTextView?.let {
            options.add(0, it)
        }
        optionTwoTextView?.let {
            options.add(1, it)
        }
        optionThreeTextView?.let {
            options.add(2, it)
        }
        optionFourTextView?.let {
            options.add(3, it)
        }
        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
            submitBtn?.text = "Submit"
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,  Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.optionOneTextView -> {
                optionOneTextView?.let {
                    selectedOptionView(it, 1)
                }
            }
            R.id.optionTwoTextView -> {
                optionTwoTextView?.let {
                    selectedOptionView(it, 2)
                }
            }
            R.id.optionThreeTextView -> {
                optionThreeTextView?.let {
                    selectedOptionView(it, 3)
                }
            }
            R.id.optionFourTextView -> {
                optionFourTextView?.let {
                    selectedOptionView(it, 4)
                }
            }
            R.id.submitBtn -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++
                    when {
                        mCurrentPosition < mQuestionsList!!.size -> {
                            setQuestion()
                        } else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition)
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg);
                    } else {
                        mCorrectAnswers++;
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg);
                    if (mCurrentPosition == mQuestionsList!!.size - 1) {
                        submitBtn?.text = "FINISH"
                    } else {
                        submitBtn?.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
            else -> {

            }
        }
    }
    private fun answerView(answer: Int, drawableView: Int) {
        when(answer) {
            1 -> {
                optionOneTextView?.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                optionTwoTextView?.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView)
            }
            3 -> {
                optionThreeTextView?.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                optionFourTextView?.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }
}