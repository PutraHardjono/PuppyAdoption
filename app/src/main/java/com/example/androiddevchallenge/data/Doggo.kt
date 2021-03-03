package com.example.androiddevchallenge.data

import java.util.*

data class Doggo (
    val name: String,
    val age: String,
    val image: Int,
    val gender: String,
    val breed: String,
    val location: String,
    val description: String,
    val id: String = UUID.randomUUID().toString()
)