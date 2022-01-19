package com.example.homeactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class RecetteJourActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recette_jour_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, RecetteJourFragment.newInstance(2))
                .commitNow()
        }
    }
}