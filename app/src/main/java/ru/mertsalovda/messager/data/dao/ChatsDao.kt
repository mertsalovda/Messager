package ru.mertsalovda.messager.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import ru.mertsalovda.messager.data.model.Chat

@Dao
interface ChatsDao {

    @Query("select * from chat")
    fun getAllChats(): LiveData<List<Chat>>

    @Query("select * from chat where id = :id")
    fun getChatById(id: Long): LiveData<Chat>

    @Insert
    fun insertChat(chat: Chat)

    @Update
    fun updateChat(chat: Chat)

    @Delete
    fun deleteChat(chat: Chat)
}