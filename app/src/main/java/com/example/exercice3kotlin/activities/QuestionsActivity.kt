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
        val types = intent.getStringExtra("themeName")
        typeText.text = types


        /**if (types == "Theme1") {
            // afficher le fragment pour le thème 1
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Theme1Fragment())
                .commit()
        } else if (types == "Theme2") {
            // afficher le fragment pour le thème 2
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Theme2Fragment())
                .commit()
        } else {
            // afficher le fragment par défaut
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, DefaultFragment())
                .commit()
        }**/

    }

}