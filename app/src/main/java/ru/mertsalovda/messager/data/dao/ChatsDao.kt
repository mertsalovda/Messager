package ru.mertsalovda.messager.data.dao

import androidx.room.*
import androidx.room.Dao
import ru.mertsalovda.messager.data.model.Chat
import ru.mertsalovda.messager.data.model.ChatAndMessages

@Dao
interface ChatsDao {

    @Query("select * from chat")
    fun getAllChats(): List<Chat>

    @Query("select * from chat where chat_id = :id")
    fun getChatById(id: Long): Chat

    @Query("select * from chat where user_uid = :uid")
    fun getChatByUserUid(uid: Long): Chat?

    @Transaction
    @Query("select * from chat where chat_id = :chatId")
    fun getChatWithMessagesById(chatId: Long): List<ChatAndMessages>

    @Transaction
    @Query("select * from chat")
    fun getChatWithMessages(): List<ChatAndMessages>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertChat(chat: Chat)

    @Update
    fun updateChat(chat: Chat)


    @Delete
    fun deleteChat(chat: Chat)
}