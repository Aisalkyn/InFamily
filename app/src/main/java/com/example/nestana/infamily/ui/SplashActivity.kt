package com.example.nestana.infamily.ui


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.example.nestana.infamily.MainActivity
import com.example.nestana.infamily.R

class SplashActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity
            val i = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(i)

            // close this activity
            finish()
        }, SPLASH_TIME_OUT.toLong())
    }

    companion object {

        // Splash screen timer
        private val SPLASH_TIME_OUT = 3000
    }

}