package com.example.databinding

data class User(
    var photo: String,
    var name: String,
    var surname: String,
    var age: Int? = 0,
    var another: String? = null
) {
}