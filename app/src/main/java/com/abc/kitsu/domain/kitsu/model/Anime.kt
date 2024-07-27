package com.abc.kitsu.domain.kitsu.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Anime(
    val id: String,
    val title: String,
    val image: String,
    val rating: String,
    val desc: String
) : Parcelable