package ru.mertsalovda.messager.data.dao

import androidx.room.*
import androidx.room.Dao
import ru.mertsalovda.messager.data.model.User

@Dao
interface UsersDao {

    @Query("select * from user")
    fun getAllUsers(): List<User>

    @Query("select * from user where user_id = :userId")
    fun getUserById(userId: Long): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Update
    fun updatetUser(user: User)

    @Delete
    fun deletetUser(user: User)
}