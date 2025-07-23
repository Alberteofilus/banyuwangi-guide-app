package com.example.banyuwangiguide

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class PlaceDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_detail)

        // Enable back button in action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val placeId = intent.getIntExtra("PLACE_ID", -1)
        val place = DataProvider.placeList.firstOrNull { it.id == placeId }

        place?.let { currentPlace ->
            // Initialize views
            val imageView: ImageView = findViewById(R.id.iv_detail_image)
            val nameTextView: TextView = findViewById(R.id.tv_detail_name)
            val locationTextView: TextView = findViewById(R.id.tv_detail_location)
            val descTextView: TextView = findViewById(R.id.tv_detail_description)
            val mapButton: Button = findViewById(R.id.btn_open_map)

            // Set data to views
            imageView.setImageResource(currentPlace.imageResId)
            nameTextView.text = currentPlace.name
            locationTextView.text = currentPlace.location
            descTextView.text = currentPlace.description
            supportActionBar?.title = currentPlace.name

            // Map button click handler
            mapButton.setOnClickListener {
                openLocationInMaps(currentPlace)
            }
        } ?: run {
            Toast.makeText(this, "Tempat tidak ditemukan", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun openLocationInMaps(place: Place) {
        val query = "${place.name}, ${place.location}"
        val uri = Uri.parse("geo:0,0?q=${Uri.encode(query)}")

        // Try to open in Google Maps app
        try {
            val mapIntent = Intent(Intent.ACTION_VIEW, uri).apply {
                setPackage("com.google.android.apps.maps")
            }
            startActivity(mapIntent)
        } catch (e: ActivityNotFoundException) {
            // Fallback 1: Try to open in browser
            try {
                val webUri = Uri.parse("https://www.google.com/maps/search/?api=1&query=${Uri.encode(query)}")
                startActivity(Intent(Intent.ACTION_VIEW, webUri))
            } catch (e: ActivityNotFoundException) {
                // Fallback 2: Show error message
                showMapErrorDialog()
            }
        }
    }

    private fun showMapErrorDialog() {
        AlertDialog.Builder(this)
            .setTitle("Aplikasi Tidak Ditemukan")
            .setMessage("Silakan install Google Maps untuk melihat lokasi")
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
            .show()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}