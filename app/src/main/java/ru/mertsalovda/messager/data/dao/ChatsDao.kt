package ru.mertsalovda.messager.data.dao

import androidx.room.*
import androidx.room.Dao
import ru.mertsalovda.messager.data.model.Chat

@Dao
interface ChatsDao {

    @Query("select * from chat")
    fun getAllChats(): List<Chat>

    @Query("select * from chat where chat_id = :id")
    fun getChatById(id: Long): Chat
    @Query("select * from chat where user_uid = :uid")
    fun getChatByUserUid(uid: Long): Chat?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertChat(chat: Chat)

    @Update
    fun updateChat(chat: Chat)


    @Delete
    fun deleteChat(chat: Chat)
}