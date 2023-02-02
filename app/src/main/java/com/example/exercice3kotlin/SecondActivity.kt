package com.example.exercice3kotlin
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.annotation.SuppressLint
import android.content.Intent
import android.widget.*




class SecondActivity : AppCompatActivity() {

    private lateinit var questionTextView: TextView
    private lateinit var optionsRadioGroup: RadioGroup
    private lateinit var submitButton: Button

    private var currentQuestion = 0

    class Question(val text: String, val options: List<String>,  val answer: String)
    private val questions = listOf(
        Question("What is the capital of France?", listOf("Paris", "London", "Berlin", "Rome"),"Paris"),
        Question("What is the largest planet in our solar system?", listOf("Jupiter", "Saturn", "Uranus", "Mars"), "Jupiter"),
        Question("What is the smallest country in the world?", listOf("Monaco", "Vatican City", "San Marino", "Nauru"), "Vatican City"),
        Question("What is the currency used in Japan?", listOf("Yen", "Won", "Dollar", "Euro"), "Yen"),
        Question("What is the highest mountain in the world?", listOf("Mount Everest", "K2", "Kangchenjunga", "Lhotse"), "Mount Everest"),
        Question("What is the name of the world's longest river?", listOf("Nile", "Amazon", "Yangtze", "Yellow"), "Nile"),
        Question("Which country is home to the Great Barrier Reef?", listOf("Australia", "South Africa", "India", "Brazil"), "Australia"),
        Question("What is the name of the world's largest desert?", listOf("Antarctica", "Sahara", "Gobi", "Kalahari"), "Sahara"),
        Question("What is the name of the world's largest ocean?", listOf("Pacific", "Atlantic", "Indian", "Arctic"), "Pacific"),
        Question("What is the name of the planet we live on?", listOf("Venus", "Mars", "Earth", "Neptune"), "Earth")
    )



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)



        /**val Image1 = findViewById<ImageView>(R.id.first_image)
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
        })**/




        questionTextView = findViewById(R.id.question_text_view)
        optionsRadioGroup = findViewById(R.id.options_radio_group)
        submitButton = findViewById(R.id.submit_button)



        fun nextQuestion() {
            questionTextView.text = questions[currentQuestion].text
            optionsRadioGroup.removeAllViews()
            for (i in 0 until questions[currentQuestion].options.size) {
                val radioButton = RadioButton(this)
                radioButton.text = questions[currentQuestion].options[i]
                optionsRadioGroup.addView(radioButton)
            }
        }

        submitButton.setOnClickListener {
            if (currentQuestion < questions.size - 1) {
                currentQuestion++
                questionTextView.text = questions[currentQuestion].answer
                optionsRadioGroup.removeAllViews()
                for (i in 0 until questions[currentQuestion].options.size) {
                    val radioButton = RadioButton(this)
                    radioButton.text = questions[currentQuestion].options[i]
                    radioButton.setPadding(10, 10, 10, 10)
                    optionsRadioGroup.addView(radioButton)
                }
            } else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }


        }
        nextQuestion()












    }

/*   submitButton.setOnClickListener {
            if (currentQuestion < questions.size - 1) {
                currentQuestion++
                questionTextView.text = questions[currentQuestion].text
                optionsRadioGroup.removeAllViews()
                for (i in 0 until questions[currentQuestion].options.size) {
                    val radioButton = RadioButton(this)
                    radioButton.text = questions[currentQuestion].options[i]
                    radioButton.setPadding(10, 10, 10, 10)
                    optionsRadioGroup.addView(radioButton)
                }
            } else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }*/



    /*private fun updateQuestion() {
        questionTextView.text = questions[currentQuestion].text
        optionsRadioGroup.removeAllViews()
        for (i in 0 until questions[currentQuestion].options.size) {
            val radioButton = RadioButton(this)
            radioButton.text = questions[currentQuestion].options[i]
            radioButton.setPadding(10, 10, 10, 10)
            optionsRadioGroup.addView(radioButton)
        }

    }*/
}

