package com.sandhirizki0088.skorutbk.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Catatan(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val tanggal: Long = System.currentTimeMillis(),
    val judul: String,
    val skor: String
)
