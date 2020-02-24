package ru.mertsalovda.messager.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Chat(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "chat_id")
    val chatId: Long,
    @ColumnInfo(name = "user_uid")
    val userUid: Long,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "unread")
    val unread: Int
)