package ru.mertsalovda.messager.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Chat(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val user: User,
    val name: String,
    val messages: MutableList<Message>,
    val unread: Int
)