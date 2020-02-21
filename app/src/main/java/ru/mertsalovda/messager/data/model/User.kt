package ru.mertsalovda.messager.data.model

import java.io.Serializable

data class User(val id: Long, val name: String, val descriptor: String) : Serializable