package com.example.cherrycinema.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cherrycinema.R
import dagger.android.AndroidInjection

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
