package com.example.exercice3kotlin

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var birthdateEditText: EditText
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.Btnnext)
        val datePickerButton = findViewById<ImageButton>(R.id.datePickerButton)

        nameEditText = findViewById(R.id.inputName)
        emailEditText = findViewById(R.id.inputEmail)
        birthdateEditText = findViewById(R.id.birthday)



        datePickerButton.setOnClickListener {
            showDatePicker()
        }

        button.setOnClickListener {
            // execute code when bottom is clicked
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val birthdate = birthdateEditText.text.toString()
            SendDataToActivity(name, email, birthdate)
            Toast.makeText(this, "Le bouton a été cliqué!", Toast.LENGTH_SHORT).show()

        }






    }
    // send Information of main activity to quiz activity
    private fun SendDataToActivity(name: String, email: String, birthdate: String) {
        val intent = Intent(this, ResultQuizz::class.java)
        intent.putExtra("NAME", name)
        intent.putExtra("EMAIL", email)
        intent.putExtra("BIRTHDATE", birthdate)
        startActivity(intent)
    }

    ////
    private var selectedDate: Calendar = Calendar.getInstance()
    //show dialog if i set button Image
    private fun showDatePicker() {
        val datePickerDialog = DatePickerDialog(
            this,
            androidx.constraintlayout.widget.R.style.Theme_AppCompat_Light_Dialog,
            dateSetListener,
            selectedDate.get(Calendar.YEAR),
            selectedDate.get(Calendar.MONTH),
            selectedDate.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }


    ////set date into TextView
    private val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, day ->
        selectedDate.set(Calendar.YEAR, year)
        selectedDate.set(Calendar.MONTH, month)
        selectedDate.set(Calendar.DAY_OF_MONTH, day)

        // Afficher la date sélectionnée dans le TextView ou EditText
        val dateTextView = findViewById<TextView>(R.id.birthday)
        val format = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        dateTextView.text = format.format(selectedDate.time)


    }



    override fun onStart() {
        super.onStart()
        Log.i("start Activity ", "activity starting ")

    }

    override fun onPause() {
        super.onPause()
        Log.i("start Activity ", "hello")
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}






