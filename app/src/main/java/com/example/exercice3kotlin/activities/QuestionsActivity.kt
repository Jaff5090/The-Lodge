package com.example.exercice3kotlin.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.exercice3kotlin.R
import com.example.exercice3kotlin.fragmentsthemes.FragmentAnimals
import com.example.exercice3kotlin.fragmentsthemes.Fragmenthistory
import com.example.exercice3kotlin.fragmentsthemes.FruitVegetables
import com.example.exercice3kotlin.fragmentsthemes.GeographyFragment

class QuestionsActivity : AppCompatActivity() {
    private lateinit var typeText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        typeText = findViewById(R.id.textType)
        val types = intent.getStringExtra("themeName")
        typeText.text = types


        if (types == "Animals") {
            // afficher le fragment pour le thème 1
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_fragment, FragmentAnimals())
                .commit()
        } else if (types == "History") {
            // afficher le fragment pour le thème 2
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_fragment, Fragmenthistory())
                .commit()
        } else if (types == "Geography"){
            // afficher le fragment par défaut
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_fragment, GeographyFragment())
                .commit()
        } else if (types == "fruits and vegetables"){
        // afficher le fragment par défaut
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_fragment, FruitVegetables())
            .commit()
    }


    }

}