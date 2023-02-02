package com.example.exercice3kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val Image1 = findViewById<ImageView>(R.id.first_image)
        val Image2 = findViewById<ImageView>(R.id.second_image)
        val Image3 = findViewById<ImageView>(R.id.third_image)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val flags = resources.getStringArray(R.array.flag_array)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, flags)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Modifiez la langue de l'application ici en fonction de la position sélectionnée
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        var selectedImage: ImageView? = null
        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        val window = window
        val attributes = window.attributes
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                attributes.screenBrightness = progress.toFloat() / 100
                window.attributes = attributes
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })


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