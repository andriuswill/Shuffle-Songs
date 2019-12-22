package com.andrius.shufflesongs.presentation.ui.splash

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.andrius.shufflesongs.R
import com.andrius.shufflesongs.data.network.RequestMusics

class SplashActivity : AppCompatActivity(), SplashContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val req = RequestMusics().execute()

    }

}