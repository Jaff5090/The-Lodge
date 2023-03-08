

package com.example.exercice3kotlin.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.exercice3kotlin.R

class SplashScreen : AppCompatActivity() {
    private lateinit var logoView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        logoView = findViewById(R.id.gifImageView)

        val animation = LogoAnimation(logoView)
        animation.duration = 2000
        animation.repeatCount = Animation.INFINITE

        logoView.startAnimation(animation)
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
            finish()
        }, 2000)

    }



    class LogoAnimation(private val logoView: ImageView) : Animation() {
        override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
            super.applyTransformation(interpolatedTime, t)

            t?.let {
                it.matrix.setRotate(360f * interpolatedTime, logoView.width / 2f, logoView.height / 2f)
            }
        }
    }

}
