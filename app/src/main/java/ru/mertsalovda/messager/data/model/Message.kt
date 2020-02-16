package ru.mertsalovda.messager.data.model

data class Message(val date: Long, val id_sender: Long, val id_target: Long, val text: String)