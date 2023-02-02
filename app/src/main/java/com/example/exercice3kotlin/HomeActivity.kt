package com.example.exercice3kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.exercice3kotlin.R
import com.example.exercice3kotlin.databinding.ActivityHomeBinding
import com.example.exercice3kotlin.databinding.ActivityHomeBinding.inflate

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.nometprenom.text = "Hello"


    }
}