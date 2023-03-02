package com.example.exercice3kotlin

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.exercice3kotlin.R
import com.example.exercice3kotlin.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.datePickerButton.setOnClickListener {
            showDatePicker()
        }

        binding.Btnnext.setOnClickListener {
            val name = binding.inputName.text.toString()
            val email = binding.inputEmail.text.toString()
            val birthdate = binding.birthday.text.toString()
            SendDataToActivity(name, email, birthdate)
            val intent = Intent(this, ThemesOfQueezActivity::class.java)
            intent.putExtra("NAME", name)
            intent.putExtra("EMAIL", email)
            intent.putExtra("BIRTHDATE", birthdate)
            startActivity(intent)
            Toast.makeText(this, "Button clicked!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun SendDataToActivity(name: String, email: String, birthdate: String) {
        val intent = Intent(this, ThemesOfQueezActivity::class.java)
        intent.putExtra("NAME", name)
        intent.putExtra("EMAIL", email)
        intent.putExtra("BIRTHDATE", birthdate)
        startActivity(intent)
    }

    private var selectedDate: Calendar = Calendar.getInstance()
    private fun showDatePicker() {
        val datePickerDialog = DatePickerDialog(
            this,
            R.style.MyCustomDialogStyle,
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
    }}






