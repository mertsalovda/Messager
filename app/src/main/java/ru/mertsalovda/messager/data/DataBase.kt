package ru.mertsalovda.messager.data

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.mertsalovda.messager.data.dao.ChatsDao
import ru.mertsalovda.messager.data.dao.MessagesDao
import ru.mertsalovda.messager.data.dao.UserLoginDao
import ru.mertsalovda.messager.data.dao.UsersDao
import ru.mertsalovda.messager.data.model.*

@Database(entities = [User::class, Chat::class, Message::class, UserLogin::class], version = 1)
abstract class DataBase : RoomDatabase() {
    abstract fun userLoginDao(): UserLoginDao
    abstract fun chatsDao(): ChatsDao
    abstract fun messagesDao(): MessagesDao
    abstract fun usersDao(): UsersDao
}