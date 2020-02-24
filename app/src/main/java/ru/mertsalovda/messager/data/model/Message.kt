package ru.mertsalovda.messager.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = Chat::class,
        parentColumns = ["chat_id"],
        childColumns = ["owner_id"],
        onDelete = CASCADE
    )]
)
data class Message(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "message_id")
    val messageId: Long,
    @ColumnInfo(name = "owner_id")
    val ownerId: Long,
    @ColumnInfo(name = "sender_uid")
    val senderUid: Long,
    @ColumnInfo(name = "target_uid")
    val targetUid: Long,
    @ColumnInfo(name = "date")
    val date: Long,
    @ColumnInfo(name = "text")
    val text: String
)