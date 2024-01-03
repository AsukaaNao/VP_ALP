package com.example.vp_alp.model

data class RestoDetailUIState (
    val restaurant: Restaurant,
    val foods: MutableList<Food>,
    val beverages:MutableList<Food>
)