package ru.mertsalovda.messager.data.dao

import androidx.room.*
import ru.mertsalovda.messager.data.model.UserLogin

@Dao
interface UserLoginDao {

    @Transaction
    suspend fun setLoggedInUser(loggedInUser: UserLogin) {
        deleteUserLogin(loggedInUser)
        insertUserLogin(loggedInUser)
    }

    @Query("select * from userlogin")
    fun getUserLogin(): List<UserLogin>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserLogin(userLogin: UserLogin)

    @Update
    fun updateUserLogin(userLogin: UserLogin)

    @Delete
    fun deleteUserLogin(userLogin: UserLogin)
}