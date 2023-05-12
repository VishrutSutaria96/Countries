package com.example.countries.model.data

import com.google.gson.annotations.SerializedName
import java.util.Currency

data class Country(
    val capital: String,
    val code: String,
    val name: String,
    val region: String
)
