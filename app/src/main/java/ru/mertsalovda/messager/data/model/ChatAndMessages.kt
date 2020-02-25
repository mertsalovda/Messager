package ru.mertsalovda.messager.data.model

import androidx.room.Embedded
import androidx.room.Relation

data class ChatAndMessages(
    @Embedded val chat: Chat,
    @Relation(
        parentColumn = "chat_id",
        entityColumn = "owner_id"
    ) val messages: List<Message>
)