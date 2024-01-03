package com.example.vp_alp.model

import java.sql.Time

data class Restaurant(
    val id: Int,
    val name: String,
    val rating: Int,
    val address: String,
    val phone: Int,
    val open_time: Time,
    val close_time: Time,
    val image: String
)
