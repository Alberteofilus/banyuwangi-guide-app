package com.example.banyuwangiguide

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup tombol-tombol
        val btnAttractions = findViewById<Button>(R.id.btn_attractions)
        val btnHiddenGems = findViewById<Button>(R.id.btn_hidden_gems)
        val btnCulinary = findViewById<Button>(R.id.btn_culinary)
        val btnEvents = findViewById<Button>(R.id.btn_events)

        btnAttractions.setOnClickListener {
            navigateToPlaceList("attraction")
        }

        btnHiddenGems.setOnClickListener {
            navigateToPlaceList("hidden_gem")
        }

        btnCulinary.setOnClickListener {
            navigateToPlaceList("culinary")
        }

        btnEvents.setOnClickListener {
            navigateToPlaceList("event")
        }
    }

    private fun navigateToPlaceList(category: String) {
        val intent = Intent(this, PlaceListActivity::class.java)
        intent.putExtra("CATEGORY", category)
        startActivity(intent)
    }
}