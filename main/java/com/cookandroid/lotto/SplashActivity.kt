package com.cookandroid.lotto

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.PersistableBundle
import com.airbnb.lottie.LottieAnimationView
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        MediaPlayer.create(this,R.raw.open).start()


        var handler = Handler(Looper.getMainLooper())
        val runnable = Runnable{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        handler.postDelayed(runnable,3000)

        animationView.setOnClickListener {
            handler.removeCallbacks(runnable)
            val inten = Intent(this,MainActivity::class.java)
            startActivity(inten)
            finish()
        }
    }
}