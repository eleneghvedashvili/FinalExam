package com.example.finalexam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {


    private lateinit var etEmailAddress: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnSingUp: TextView
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAuth = FirebaseAuth.getInstance()
        if (mAuth.currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()

        }
        setContentView(R.layout.activity_login)



        etEmailAddress= findViewById(R.id.etEmailAddress)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnSingUp = findViewById(R.id.btnSingUp)

        btnSingUp.setOnClickListener(){
            startActivity(Intent(this, SingUpActivity::class.java))
        }

        btnLogin.setOnClickListener {
            val email = etEmailAddress.text.toString()
            val password = etPassword.text.toString()
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Email and Password can't be blank.", Toast.LENGTH_LONG).show()
            } else {
                mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            finish()

                        } else {
                            Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()


                        }


                    }



            }
        }

    }
}