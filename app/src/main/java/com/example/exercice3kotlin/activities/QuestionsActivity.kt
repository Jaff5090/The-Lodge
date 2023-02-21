package com.example.exercice3kotlin.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.exercice3kotlin.R

class QuestionsActivity : AppCompatActivity() {
    private lateinit var typeText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        typeText = findViewById(R.id.textType)
        val types = intent.getStringExtra("Type")
        typeText.text = types

    }
}