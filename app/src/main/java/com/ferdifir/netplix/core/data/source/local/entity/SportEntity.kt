package com.ferdifir.netplix.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sport")
data class SportEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "idSport")
    val idSport: String,

    @ColumnInfo(name = "strFormat")
    val strFormat: String,

    @ColumnInfo(name = "strSport")
    val strSport: String,

    @ColumnInfo(name = "strSportIconGreen")
    val strSportIconGreen: String,

    @ColumnInfo(name = "strSportThumb")
    val strSportThumb: String,

    @ColumnInfo(name = "strSportDescription")
    val strSportDescription: String,

    @ColumnInfo(name = "isLiked")
    var strLiked: Boolean = false
)
