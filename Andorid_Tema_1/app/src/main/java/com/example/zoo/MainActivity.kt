package com.example.zoo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, ZooListFragment()) // Replace nav_host_fragment with ZooListFragment
            .commit()

        val button: Button = findViewById(R.id.close_button)
        button.setOnClickListener { goToSecondActivity() }
    }

    private fun goToSecondActivity() {
        finish() // Close the current activity
    }
}
