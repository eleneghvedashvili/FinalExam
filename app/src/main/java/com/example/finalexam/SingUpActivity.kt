package com.example.finalexam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SingUpActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var etEmailAddress: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var btnSingUp: Button
    private lateinit var btnLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_up)
        firebaseAuth = FirebaseAuth.getInstance()

        etEmailAddress = findViewById(R.id.etEmailAddress)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        btnSingUp = findViewById(R.id.btnSingUp)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener(){
            startActivity(Intent(this, LoginActivity::class.java))
        }

        btnSingUp.setOnClickListener(){
            val email = etEmailAddress.text.toString()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()
            if(password==confirmPassword) {

                if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()

                } else {
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                startActivity(Intent(this, MainActivity::class.java))
                                finish()
                            } else {
                                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                            }
                        }

                }
            }
        }
    }

    private fun singUpUser (){
        val email = etEmailAddress.text.toString()
        val password = etPassword.text.toString()
        val confirmPassword = etConfirmPassword.text.toString()

        if(email.isBlank() || password.isBlank() || confirmPassword.isBlank()){
            Toast.makeText(this,"Email and Password can't be blank.", Toast.LENGTH_SHORT).show()
            return
        }

        if(password != confirmPassword){
            Toast.makeText(this,"Password and Confirm Password doesn't match ", Toast.LENGTH_SHORT).show()
            return
        }



        firebaseAuth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){
                if(it.isSuccessful){
                    Toast.makeText(this,"Successful", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this,"Error Creating User.", Toast.LENGTH_SHORT).show()
                }
            }
    }

}