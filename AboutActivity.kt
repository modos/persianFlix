package com.modos.persianflix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
    }

    override fun onPause() {
        super.onPause()
        overridePendingTransition(R.anim.no_animation, R.anim.slide_down)
    }
}
