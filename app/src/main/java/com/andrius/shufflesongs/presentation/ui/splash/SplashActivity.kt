package com.andrius.shufflesongs.presentation.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.andrius.shufflesongs.R
import com.andrius.shufflesongs.presentation.ui.main.MainActivity


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val handler = Handler()
        handler.postDelayed(Runnable {
            super.onResume()
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }, 2000)

    }
}