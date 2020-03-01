package ru.mertsalovda.messager.data.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    val id: Long,
    @ColumnInfo(name = "user_uid")
    val uid: Long,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "about")
    val about: String,
    @ColumnInfo(name = "last_time")
    val lastTime: Long,
    @ColumnInfo(name = "image_url")
    val imageUrl: String
)