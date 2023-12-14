package com.eduproject.pmob.data.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "kosan")
data class MainEntity (
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "alamat")
    var alamat: String,

    @ColumnInfo(name = "fasilitas")
    var fasilitas: String,

    @ColumnInfo(name = "images")
    var images: String  = "",

    @ColumnInfo(name = "lon")
    var lon: Double,

    @ColumnInfo(name = "lat")
    var lat: Double,
): Parcelable