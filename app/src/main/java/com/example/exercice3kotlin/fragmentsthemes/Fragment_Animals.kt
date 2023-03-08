package com.example.exercice3kotlin.fragmentsthemes

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.exercice3kotlin.R
import com.example.exercice3kotlin.ThemesOfQueezActivity
import com.example.exercice3kotlin.databinding.FragmentAnimalsBinding
import com.google.gson.Gson



class FragmentAnimals : Fragment() {
    private lateinit var questionTextView: TextView
    private lateinit var optionsRadioGroup: RadioGroup
    private lateinit var submitButton: Button
    private var score = 0
    private var currentQuestion = 0

    class Question(val text: String, val options: List<String>, val answer: String)
    private val questions = mutableListOf<Question>()




    private lateinit var binding: FragmentAnimalsBinding
    private lateinit var optionsLinearLayout: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {

        binding = FragmentAnimalsBinding.inflate(inflater, container, false)
        questionTextView = binding.questionTextView
        optionsLinearLayout = binding.optionsLinearLayout
        submitButton = binding.submitButton
        val jsonString = context?.assets?.open("animals.json")?.bufferedReader().use { it?.readText() }

        if (!jsonString.isNullOrEmpty()) {
            val gson = Gson()
            questions.addAll(gson.fromJson(jsonString, Array<Question>::class.java).toList())
        } else {
            // gérer le cas où le fichier JSON est introuvable
            Toast.makeText(requireContext(), "Fichier JSON introuvable!", Toast.LENGTH_SHORT).show()
        }






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
                score++
                Toast.makeText(requireContext(), "Correct Answer!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Incorrect Answer!", Toast.LENGTH_SHORT).show()
            }
            if (currentQuestion < questions.size - 1) {
                currentQuestion++
                nextQuestion()
            } else {
                val score = calculateScore()
                val dialogBuilder = AlertDialog.Builder(requireContext())
                    .setTitle("Quiz Score")
                    .setMessage("You scored $score out of ${questions.size}")
                    .setPositiveButton("OK") { dialog, which ->
                        // Navigate back to the MainActivity

                    }
                    .setNegativeButton("Retour") { dialog, which ->
                        // Navigate back to the quiz themes activity
                        val intent = Intent(activity, ThemesOfQueezActivity::class.java)
                        startActivity(intent)
                    }
                dialogBuilder.create().show()

            }
        }

        return binding.root
    }
    private fun calculateScore(): Int {
        return score
    }


    private fun getSelectedOption(question: Question): String? {
        for (i in 0 until optionsLinearLayout.childCount) {
            val view = optionsLinearLayout.getChildAt(i)
            if (view is RelativeLayout) {
                val optionTextView = view.getChildAt(0) as TextView
                if (view.backgroundTintList == ColorStateList.valueOf(Color.GREEN)) {
                    return optionTextView.text.toString()
                }
            }
        }
        return null
    }



    private fun nextQuestion() {
        questionTextView.text = questions[currentQuestion].text
        optionsLinearLayout.removeAllViews()
        for (i in 0 until questions[currentQuestion].options.size) {
            val optionRelativeLayout = RelativeLayout(requireContext())


            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(0, 10, 0, 0)
            optionRelativeLayout.layoutParams = params
            optionRelativeLayout.setBackgroundResource(R.drawable.rectangle)
            optionRelativeLayout.setOnClickListener {
                optionRelativeLayout.backgroundTintList = ColorStateList.valueOf(Color.GREEN)
                for (j in 0 until optionsLinearLayout.childCount) {
                    val view = optionsLinearLayout.getChildAt(j)
                    view.isClickable = false
                }
            }
            val optionTextView = TextView(requireContext())
            optionTextView.text = questions[currentQuestion].options[i]
            optionTextView.setPadding(10, 10, 10, 10)
            optionRelativeLayout.addView(optionTextView)
            optionsLinearLayout.addView(optionRelativeLayout)
        }
    }
}
