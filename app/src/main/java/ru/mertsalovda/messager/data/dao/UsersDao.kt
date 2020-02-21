package ru.mertsalovda.messager.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import ru.mertsalovda.messager.data.model.User

@Dao
interface UsersDao {

    @Query("select * from user")
    fun getAllUsers(): LiveData<List<User>>

    @Insert
    fun insertUser(user: User)

    @Update
    fun updatetUser(user: User)

    @Delete
    fun deletetUser(user: User)
}