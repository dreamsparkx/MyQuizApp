package com.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val nameTextView: TextView = findViewById(R.id.nameTextView)
        val scoreTetView: TextView = findViewById(R.id.scoreTetView)
        val finishButton: Button = findViewById(R.id.finishButton)
        nameTextView.text = intent.getStringExtra(Constants.USER_NAME)
        val totalCorrectAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        scoreTetView.text = "Your score is ${totalCorrectAnswers} out of ${totalQuestions}"
        finishButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
//    https://tutorials.eu/generate-a-signed-apk-in-android-studio-and-upload-it-on-google-play-store/
}