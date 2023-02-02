package com.example.exercice3kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultQuizz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_quizz)
        val name = intent.getStringExtra("NAME")
        val email = intent.getStringExtra("EMAIL")
        val birthdate = intent.getStringExtra("BIRTHDATE")

        val nameTextView = findViewById<TextView>(R.id.nomIT)
        val emailTextView = findViewById<TextView>(R.id.emailIt)
        val birthdateTextView = findViewById<TextView>(R.id.dateIT)

        nameTextView.text = name
        emailTextView.text = email
        birthdateTextView.text = birthdate
    }
}