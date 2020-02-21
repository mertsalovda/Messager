package ru.mertsalovda.messager.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val uid: Long,
    val name: String,
    val about: String,
    val lastTime: Long,
    val avatar: Image
)