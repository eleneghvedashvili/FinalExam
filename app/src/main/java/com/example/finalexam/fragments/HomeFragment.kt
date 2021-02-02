package com.example.finalexam.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.finalexam.Game
import com.example.finalexam.R
import com.example.finalexam.SingUpActivity

class HomeFragment: Fragment(R.layout.fragment_home) {

    private lateinit var btnstartGame: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnstartGame = view.findViewById(R.id.btnstartGame)
        btnstartGame.setOnClickListener {
            startActivity(Intent(getContext(), Game::class.java))
            getActivity()?.finish()
        }

    }

}