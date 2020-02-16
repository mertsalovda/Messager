package ru.mertsalovda.messager.data.model


data class Chat(val id: Long, val name: String, val messages: MutableList<Message>)