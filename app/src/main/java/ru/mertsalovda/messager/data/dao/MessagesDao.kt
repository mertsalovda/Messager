package ru.mertsalovda.messager.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import ru.mertsalovda.messager.data.model.Message

interface MessagesDao {

    @Query("select * from message where senderId = :id")
    fun getAllMessageFromSender(id: Long): LiveData<List<Message>>

    @Insert
    fun insertMessage(message: Message)

    @Update
    fun updateMessage(message: Message)

    @Delete
    fun deleteMessage(message: Message)
}