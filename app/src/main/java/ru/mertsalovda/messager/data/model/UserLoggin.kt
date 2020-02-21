package ru.mertsalovda.messager.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
@Entity
data class UserLoggin(
    @PrimaryKey
    val id: Long,
    val uid: String,
    val name: String,
    val about: String,
    val token: String
)
