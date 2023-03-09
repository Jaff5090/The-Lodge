package com.example.exercice3kotlin.fragmentsthemes

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.exercice3kotlin.R
import com.example.exercice3kotlin.activities.ThemesOfQueezActivity
import com.example.exercice3kotlin.databinding.FragmentGeographyBinding
import com.google.gson.Gson

class GeographyFragment : Fragment() {
    private lateinit var questionTextView: TextView
    private lateinit var submitButton: Button

    private var score = 0
    private var currentQuestion = 0


    private lateinit var binding: FragmentGeographyBinding
    private lateinit var optionsLinearLayout: LinearLayout
    class Question(val text: String, val options: List<String>, val answer: String)
    private val questions = mutableListOf<Question>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentGeographyBinding.inflate(inflater, container, false)
        questionTextView = binding.questionTextView
        optionsLinearLayout = binding.optionsLinearLayout
        submitButton = binding.submitButton


        val jsonString = context?.assets?.open("geography.json")?.bufferedReader().use { it?.readText() }

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
                    .setPositiveButton("OK") { _, _ ->
                        // TODO :  Navigate back to the MainActivity
                    }
                    .setNegativeButton("Retour") { _, _ ->
                        // TODO : Navigate back to the quiz themes activity
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



    private var selectedOptionRelativeLayout: RelativeLayout? = null

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
                if (selectedOptionRelativeLayout != null) {
                    selectedOptionRelativeLayout?.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(requireContext(), R.color.gray)
                    )
                }
                optionRelativeLayout.backgroundTintList = ColorStateList.valueOf(Color.GREEN)
                selectedOptionRelativeLayout = optionRelativeLayout
            }
            val optionTextView = TextView(requireContext())
            optionTextView.text = questions[currentQuestion].options[i]
            optionTextView.setPadding(10, 10, 10, 10)
            optionRelativeLayout.addView(optionTextView)
            optionsLinearLayout.addView(optionRelativeLayout)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("GeographyFragment", "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("GeographyFragment", "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("GeographyFragment", "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("GeographyFragment", "onStop called")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("GeographyFragment", "onDestroyView called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("GeographyFragment", "onDestroy called")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("GeographyFragment", "onDetach called")
    }}