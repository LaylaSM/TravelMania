package com.laylamac.travelmania.model

import android.graphics.drawable.Drawable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class OnboardingMdl(
    @SerializedName("background")
    val background: Drawable,
    @SerializedName("title")
    val title: String
) : Serializable
