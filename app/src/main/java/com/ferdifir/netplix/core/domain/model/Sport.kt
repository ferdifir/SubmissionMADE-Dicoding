package com.ferdifir.netplix.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sport(
    val idSport: String,
    val strFormat: String,
    val strSport: String,
    val strSportIconGreen: String,
    val strSportThumb: String,
    val strSportDescription: String,
    val strLiked: Boolean = false
): Parcelable