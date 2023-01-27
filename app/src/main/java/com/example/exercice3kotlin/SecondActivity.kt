package com.example.exercice3kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val Image1 = findViewById<ImageView>(R.id.first_image)
        val Image2 = findViewById<ImageView>(R.id.second_image)
        val Image3 = findViewById<ImageView>(R.id.third_image)

        var selectedImage: ImageView? = null

        Image1.setOnClickListener {
            if (selectedImage != null) {
                selectedImage!!.clearColorFilter()
            }
            Image1.setColorFilter(R.color.black)
            selectedImage = Image1
        }

        Image2.setOnClickListener {
            if (selectedImage != null) {
                selectedImage!!.clearColorFilter()
            }
            Image2.setColorFilter(R.color.black)
            selectedImage = Image2
        }

        Image3.setOnClickListener {
            if (selectedImage != null) {
                selectedImage!!.clearColorFilter()
            }
            Image3.setColorFilter(R.color.black)
            selectedImage = Image3
        }



    }

}