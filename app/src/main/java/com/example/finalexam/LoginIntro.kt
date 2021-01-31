package com.example.finalexam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LoginIntro : AppCompatActivity() {
    private lateinit var txtLoginSubHeader: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_intro)


        txtLoginSubHeader = findViewById(R.id.btnGetStarted)

        txtLoginSubHeader.setOnClickListener(){
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}