package com.example.exercice3kotlin.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exercice3kotlin.R
import com.example.exercice3kotlin.adapter.ThemeQuizAdapter
import com.example.exercice3kotlin.ui.quiz.QuizThemeViewModel

class ThemesQuiz : AppCompatActivity() {
    private lateinit var nameR: TextView
    private lateinit var birthR: TextView
    private lateinit var ButtomItems: ImageView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_themes_of_queez)
        ButtomItems = findViewById(R.id.ButtomItems)
        nameR = findViewById(R.id.setName)
        birthR = findViewById(R.id.setBirthday)

        val name = intent.getStringExtra("NAME")
        val bithR = intent.getStringExtra("BIRTHDATE")

        nameR.setText(name)
        birthR.setText(bithR)
        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.rvThemeQuiz)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.addItemDecoration(SmallerItemDecoration(10))


        // ArrayList of class ItemsViewModel
        val data = ArrayList<QuizThemeViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 1..8) {
            data.add(QuizThemeViewModel(R.drawable.ic_baseline_settings_24, "item" + i))
        }

        // This will pass the ArrayList to our Adapter
        val adapter = ThemeQuizAdapter(data)

        // Setting OnClickListener for the adapter
        adapter.setOnClickListener(object : ThemeQuizAdapter.OnClickListener {
            override fun onClick(position: Int) {
                val intent = Intent(this@ThemesQuiz, Navigations::class.java)
                startActivity(intent)
            }
        })
        ButtomItems.setOnClickListener {
            val items = arrayOf("Themes quiz","account", "profile")
            val builder = AlertDialog.Builder(this)

            builder.setItems(items) { dialog, which ->
                when (which) {
                    0 -> {
                        // action for item 1 (Compte)
                    }
                    1 -> {
                        // action for item 2 (Paramètres)
                    }
                    2 -> {
                        // action for item 2 (Paramètres)
                    }

                }
            }
            val dialog = builder.create()
            val window = dialog.window
            window!!.setGravity(Gravity.TOP or Gravity.END)
            val params = window.attributes

            params.verticalMargin = 0.0f
            params.horizontalMargin = 0.0f
            window.attributes = params

            dialog.show()
        }



        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

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
