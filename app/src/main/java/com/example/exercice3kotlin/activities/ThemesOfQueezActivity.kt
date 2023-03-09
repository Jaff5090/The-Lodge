package com.example.exercice3kotlin.activities

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exercice3kotlin.R
import com.example.exercice3kotlin.adapter.ThemeQuizAdapter
import com.example.exercice3kotlin.databinding.ActivityThemesOfQueezBinding

class ThemesOfQueezActivity : AppCompatActivity() {

    companion object {
        const val NAME_KEY = "NAME"
        const val BIRTHDATE_KEY = "BIRTHDATE"
    }
    private lateinit var binding: ActivityThemesOfQueezBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThemesOfQueezBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name = intent.getStringExtra(NAME_KEY)
        val bithR = intent.getStringExtra(BIRTHDATE_KEY)

        binding.setName.text = name
        binding.setBirthday.text = bithR

        binding.rvThemeQuiz.layoutManager = LinearLayoutManager(this)
        binding.rvThemeQuiz.addItemDecoration(SmallerItemDecoration(10))

        val data = ArrayList<QuizThemeViewModel>()
        data.add(QuizThemeViewModel(R.drawable.animals, getString(R.string.quiz_theme_animals)))
        data.add(QuizThemeViewModel(R.drawable.history, getString(R.string.quiz_theme_history)))
        data.add(QuizThemeViewModel(R.drawable.geogra, getString(R.string.quiz_theme_geography)))
        data.add(QuizThemeViewModel(R.drawable.fruits, getString(R.string.quiz_theme_fruits_and_veggies)))

        val adapter = ThemeQuizAdapter(data)
        binding.rvThemeQuiz.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        Log.d("ThemesOfQueezActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ThemesOfQueezActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("ThemesOfQueezActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("ThemesOfQueezActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ThemesOfQueezActivity", "onDestroy")
    }
}

class SmallerItemDecoration(private val height: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.bottom = height
    }
}
