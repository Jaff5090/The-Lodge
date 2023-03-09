package com.example.exercice3kotlin.activities

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.example.exercice3kotlin.R
import com.example.exercice3kotlin.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    companion object {
        const val NAME_KEY = "NAME"
        const val BIRTHDATE_KEY = "BIRTHDATE"
    }
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        // TODO : Date Picker
        binding.datePickerButton.setOnClickListener {
            showDatePicker()
        }

        binding.Btnnext.setOnClickListener {
            val name = binding.inputName.text.toString()
            val birthdate = binding.birthday.text.toString()

            // TODO : verify if texts are empty
            if (name.isEmpty() || birthdate.isEmpty()) {
                Toast.makeText(this, "remplir les champs svp ", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // TODO : put data into ThemeQuiz Activity
            val intent = Intent(this, ThemesOfQueezActivity::class.java)
            intent.putExtra(NAME_KEY, name)
            intent.putExtra(BIRTHDATE_KEY, birthdate)
            startActivity(intent)
            Toast.makeText(this, "Button clicked!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy called")
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
    }
}







