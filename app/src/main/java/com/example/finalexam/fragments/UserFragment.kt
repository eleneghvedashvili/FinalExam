package com.example.finalexam.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.finalexam.LoginActivity
import com.example.finalexam.R
import com.example.finalexam.SingUpActivity
import com.google.firebase.auth.FirebaseAuth

class UserFragment: Fragment(R.layout.fragment_user) {

    private lateinit var txtName: TextView
    private lateinit var txtEmail: TextView
    private lateinit var idUser: TextView
    private lateinit var btnNewAccount: Button
    private lateinit var btnLogout2: Button
    private lateinit var mAuth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAuth= FirebaseAuth.getInstance()

        val currentuser = mAuth.currentUser

        txtName= view.findViewById(R.id.txtName)
        txtEmail = view.findViewById(R.id.txtEmail)
        idUser = view.findViewById(R.id.idUser)
        btnNewAccount = view.findViewById(R.id.btnNewAccount)
        btnLogout2 = view.findViewById(R.id.btnLogout2)

        txtName.text = currentuser?.uid
        txtEmail.text = currentuser?.email
        idUser.text = currentuser?.displayName


        btnNewAccount.setOnClickListener{
            startActivity(Intent(getContext(), SingUpActivity::class.java))
            getActivity()?.finish()
        }


        btnLogout2.setOnClickListener {
            startActivity(Intent(getContext(), LoginActivity::class.java))
            getActivity()?.finish()

            mAuth.signOut()
        }

    }

}