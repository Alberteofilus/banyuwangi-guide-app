package com.example.banyuwangiguide

data class Place(
    val id: Int,
    val name: String,
    val description: String,
    val location: String,
    val imageResId: Int,
    val category: String // "attraction", "hidden_gem", "culinary", "event"
)