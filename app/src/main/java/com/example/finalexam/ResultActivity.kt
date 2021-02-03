package com.example.finalexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    private lateinit var winning: ImageView
    private lateinit var results: TextView
    private lateinit var congratulations: TextView
    private lateinit var score: TextView
    private lateinit var btn_Finish: Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        winning = findViewById(R.id.winning)
        results = findViewById(R.id.results)
        congratulations = findViewById(R.id.congratulations)
        score = findViewById(R.id.score)
        btn_Finish = findViewById(R.id.btn_Finish)

        val total_questions = intent.getIntExtra(Constans.TOTAL_QUESTIONS,0)
        val correct_answers = intent.getIntExtra(Constans.CORRECT_ANSWERS,0)

        score.text = "Your score is $correct_answers out of $total_questions"

        btn_Finish.setOnClickListener{
            startActivity(Intent(this, Game::class.java))
        }


    }
}