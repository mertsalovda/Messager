package ru.mertsalovda.messager.data.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.properties.Delegates

@Entity
class User constructor() {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    var id: Long =0
    @ColumnInfo(name = "user_uid")
    var uid: Long =0
    @ColumnInfo(name = "name")
    var name: String = ""
    @ColumnInfo(name = "about")
    var about: String = ""
    @ColumnInfo(name = "last_time")
    var lastTime: Long = 0
    @ColumnInfo(name = "image_url")
    var imageUrl: String = ""

    constructor(
        id: Long,
        uid: Long,
        name: String,
        about: String,
        lastTime: Long,
        imageUrl: String
    ) : this() {
        this.id = id
        this.uid = uid
        this.name = name
        this.about = about
        this.lastTime = lastTime
        this.imageUrl = imageUrl
    }
}