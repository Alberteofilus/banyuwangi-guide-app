package com.example.banyuwangiguide

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PlaceListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_list)

        // Enable back button in action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val category = intent.getStringExtra("CATEGORY") ?: ""
        val places = DataProvider.getPlacesByCategory(category)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_places)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PlaceAdapter(places) { place ->
            val intent = Intent(this, PlaceDetailActivity::class.java)
            intent.putExtra("PLACE_ID", place.id)
            startActivity(intent)
        }

        // Set title based on category
        supportActionBar?.title = when(category) {
            "attraction" -> "Tempat Wisata"
            "hidden_gem" -> "Tempat Rahasia"
            "culinary" -> "Kuliner Khas"
            "event" -> "Event & Festival"
            else -> "Banyuwangi Guide"
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}