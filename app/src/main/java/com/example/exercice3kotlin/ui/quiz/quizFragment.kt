package com.example.exercice3kotlin.ui.quiz

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Color.green
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.*
import androidx.fragment.app.Fragment
import com.example.exercice3kotlin.MainActivity
import com.example.exercice3kotlin.R
import com.example.exercice3kotlin.databinding.FragmentHomeBinding

class quizFragment : Fragment() {
    private lateinit var questionTextView: TextView
    private lateinit var optionsRadioGroup: RadioGroup
    private lateinit var submitButton: Button


    private var currentQuestion = 0

    class Question(val text: String, val options: List<String>, val answer: String)
    private val questions = listOf(
        Question("What is the capital of France?", listOf("Paris", "London", "Berlin", "Rome"),"Paris"),
        Question("What is the largest planet in our solar system?", listOf("Jupiter", "Saturn", "Uranus", "Mars"),"Mars"),
        Question("What is the smallest country in the world?", listOf("Monaco", "Vatican City", "San Marino", "Nauru"),"San Marino"),
        Question("What is the currency used in Japan?", listOf("Yen", "Won", "Dollar", "Euro"),"Yen"),
        Question("What is the highest mountain in the world?", listOf("Mount Everest", "K2", "Kangchenjunga", "Lhotse"),"K2"),
        Question("What is the name of the world's longest river?", listOf("Nile", "Amazon", "Yangtze", "Yellow"),"Yellow"),
        Question("Which country is home to the Great Barrier Reef?", listOf("Australia", "South Africa", "India", "Brazil"),"India"),
        Question("What is the name of the world's largest desert?", listOf("Antarctica", "Sahara", "Gobi", "Kalahari"),"Gobi"),
        Question("What is the name of the world's largest ocean?", listOf("Pacific", "Atlantic", "Indian", "Arctic"),"Indian"),
        Question("What is the name of the planet we live on?", listOf("Venus", "Mars", "Earth", "Neptune"),"Mars")
    )

    private lateinit var binding: FragmentHomeBinding
    private lateinit var optionsLinearLayout: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        questionTextView = binding.questionTextView
        optionsLinearLayout = binding.optionsLinearLayout
        submitButton = binding.submitButton

        nextQuestion()

        submitButton.setOnClickListener {
            var selectedOption: String? = null
            for (i in 0 until optionsLinearLayout.childCount) {
                val view = optionsLinearLayout.getChildAt(i)
                if (view is RelativeLayout) {
                    val optionTextView = view.getChildAt(0) as TextView
                    if (view.backgroundTintList == ColorStateList.valueOf(Color.GREEN)) {
                        selectedOption = optionTextView.text.toString()
                        break
                    }
                }
            }
            val answer = questions[currentQuestion].answer
            if (selectedOption == answer) {
                Toast.makeText(requireContext(), "Correct Answer!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Incorrect Answer!", Toast.LENGTH_SHORT).show()
            }
            if (currentQuestion < questions.size - 1) {
                currentQuestion++
                nextQuestion()
            } else {
                val intent = Intent(activity, MainActivity::class.java)
                startActivity(intent)
            }
        }


        return binding.root
    }


    private fun nextQuestion() {
        questionTextView.text = questions[currentQuestion].text
        optionsLinearLayout.removeAllViews()
        for (i in 0 until questions[currentQuestion].options.size) {
            val optionRelativeLayout = RelativeLayout(requireContext())
            optionRelativeLayout.setBackgroundResource(R.drawable.rectangle)
            optionRelativeLayout.setOnClickListener {
                optionRelativeLayout.backgroundTintList = ColorStateList.valueOf(Color.GREEN)
            }
            val optionTextView = TextView(requireContext())
            optionTextView.text = questions[currentQuestion].options[i]
            optionTextView.setPadding(10, 10, 10, 10)
            optionRelativeLayout.addView(optionTextView)
            optionsLinearLayout.addView(optionRelativeLayout)
        }
    }
}
