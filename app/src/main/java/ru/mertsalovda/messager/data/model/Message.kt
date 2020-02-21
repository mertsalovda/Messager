package ru.mertsalovda.messager.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Message(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val senderId: Long,
    val targetId: Long,
    val date: Long,
    val text: String
)