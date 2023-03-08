package com.example.exercice3kotlin.fragmentsthemes

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
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
import com.example.exercice3kotlin.databinding.FragmentGeographyBinding

class GeographyFragment : Fragment() {
    private lateinit var questionTextView: TextView
    private lateinit var optionsRadioGroup: RadioGroup
    private lateinit var submitButton: Button
    private var score = 0


    private var currentQuestion = 0

    class Question(val text: String, val options: List<String>, val answer: String)
    private val questions = listOf(
        Question("Quelle est la capitale de la France?", listOf("Paris", "Londres", "Berlin", "Rome"), "Paris"),
        Question("Quel est le plus grand planète dans notre système solaire?", listOf("Jupiter", "Saturne", "Uranus", "Mars"), "Jupiter"),
        Question("Quel est le plus petit pays dans le monde?", listOf("Monaco", "Vatican", "Saint-Marin", "Nauru"), "Saint-Marin"),
        Question("Quelle est la monnaie utilisée au Japon?", listOf("Yen", "Won", "Dollar", "Euro"), "Yen"),
        Question("Quel est le plus haut montagne dans le monde?", listOf("Mont Everest", "K2", "Kangchenjunga", "Lhotse"), "Mont Everest"),
        Question("Quel est le nom du plus long fleuve du monde?", listOf("Nil", "Amazone", "Yangtze", "Jaune"), "Nil"),
        Question("Quel pays est la maison du grand récif de corail?", listOf("Australie", "Afrique du Sud", "Inde", "Brésil"), "Australie"),
        Question("Quel est le nom du plus grand désert du monde?", listOf("Antarctique", "Sahara", "Gobi", "Kalahari"), "Sahara"),
        Question("Quel est le nom de l'océan le plus grand du monde?", listOf("Pacifique", "Atlantique", "Indien", "Arctique"), "Pacifique"),
        Question("Quel est le nom de la planète sur laquelle nous vivons?", listOf("Vénus", "Mars", "Terre", "Neptune"), "Terre")
    )

    private lateinit var binding: FragmentGeographyBinding
    private lateinit var optionsLinearLayout: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentGeographyBinding.inflate(inflater, container, false)
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