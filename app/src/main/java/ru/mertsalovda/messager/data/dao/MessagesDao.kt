package ru.mertsalovda.messager.data.dao

import androidx.room.*
import ru.mertsalovda.messager.data.model.Message

@Dao
interface MessagesDao {

    @Query("select * from message where owner_id = :chatId")
    fun getAllMessageByChatId(chatId: Long): List<Message>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMessage(message: Message)

    @Update
    fun updateMessage(message: Message)

    @Delete
    fun deleteMessage(message: Message)
}