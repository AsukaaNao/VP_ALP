package com.example.vp_alp.model

import androidx.annotation.DrawableRes

data class near(
    var name: String,
    var rating: Float,
    var address: String,
    var phone:String,
    @DrawableRes val image_path:Int,

    )
