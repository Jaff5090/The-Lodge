
package com.example.exercice3kotlin.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.exercice3kotlin.databinding.ActivitySplashscreenBinding
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashscreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animation = LogoAnimation(binding.gifImageView)
        animation.duration = 2000
        animation.repeatCount = Animation.INFINITE
        binding.gifImageView.startAnimation(animation)

       // TODO Thread splashScreen
        val executor = Executors.newSingleThreadScheduledExecutor()
        executor.schedule({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
            finish()
        }, 2000, TimeUnit.MILLISECONDS)
    }


    // TODO : Logo animation class

    class LogoAnimation(private val logoView: ImageView) : Animation() {
        override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
            super.applyTransformation(interpolatedTime, t)

            t?.matrix?.setRotate(360f * interpolatedTime, logoView.width / 2f, logoView.height / 2f)
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d("SplashScreen", "onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("SplashScreen", "onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("SplashScreen", "onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("SplashScreen", "onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SplashScreen", "onDestroy Called")
    }



}
