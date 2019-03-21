package com.laylamac.travelmania

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {

    private var mHandler: Handler? = null
    private val SPLASH_DELAY: Long = 3000

    private val mRunnable: Runnable = Runnable {
        if (!isFinishing) {
            val intent = Intent(applicationContext, Onboarding::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        mHandler = Handler()
        mHandler!!.postDelayed(mRunnable, SPLASH_DELAY)

    }

    public override fun onDestroy() {
        if (mHandler != null) {
            mHandler!!.removeCallbacks(mRunnable)

        }
        super.onDestroy()
    }
}
