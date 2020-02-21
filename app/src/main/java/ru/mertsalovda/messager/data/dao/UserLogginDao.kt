package ru.mertsalovda.messager.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import ru.mertsalovda.messager.data.model.UserLoggin

@Dao
interface UserLogginDao {

    @Query("select * from userloggin")
    fun getUserLoggin(): LiveData<UserLoggin>

    @Insert
    fun insertUserLoggin(userLoggin: UserLoggin)

    @Update
    fun updateUserLoggin(userLoggin: UserLoggin)

    @Delete
    fun deleteUserLoggin(userLoggin: UserLoggin)
}