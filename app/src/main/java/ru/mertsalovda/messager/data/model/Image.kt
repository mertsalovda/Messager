package ru.mertsalovda.messager.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Image(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val photoUrl: String,
    val userUID: Long,
    val userId: Long
)