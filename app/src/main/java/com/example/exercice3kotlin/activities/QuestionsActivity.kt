package com.example.exercice3kotlin.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.GravityCompat
import com.example.exercice3kotlin.R
import com.example.exercice3kotlin.databinding.ActivityQuestionsBinding
import com.example.exercice3kotlin.fragmentsthemes.*

class QuestionsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuestionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val types = intent.getStringExtra("themeName")
        val navigationView = binding.navView

        binding.textType.text = types
        // TODO : drawer nav
        binding.drawerIcon.setOnClickListener {
            if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                binding.drawerLayout.openDrawer(GravityCompat.START)
            }
        }
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.item1 -> {
                    // démarrer l'activité Thème pour l'élément 1
                    val intent = Intent(this, ThemesOfQueezActivity::class.java)
                    startActivity(intent)
                }

            }
            // fermer le tiroir après avoir sélectionné un élément
            true
        }


        // TODO fragments replace in activity
        if (types == getString(R.string.quiz_theme_animals)) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_fragment, FragmentAnimals())
                .commit()
        } else if (types == getString(R.string.quiz_theme_history)) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_fragment, Fragmenthistory())
                .commit()
        } else if (types == getString(R.string.quiz_theme_geography)){
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_fragment, GeographyFragment())
                .commit()
        } else if (types == getString(R.string.quiz_theme_fruits_and_veggies)){
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_fragment, FruitVegetables())
                .commit()
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d("QuestionsActivity", "onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("QuestionsActivity", "onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("QuestionsActivity", "onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("QuestionsActivity", "onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("QuestionsActivity", "onDestroy Called")
    }
}


