package ru.mertsalovda.messager.data

import ru.mertsalovda.messager.data.model.Chat
import ru.mertsalovda.messager.data.model.Message

class ChatRepository {

    private val chats = mutableListOf<Chat>()

    init {
        val message1 = Message(134656456456L, 1, 2, "Hello")
        val message2 = Message(324464564645L, 2, 1, "Hello")
        val message3 = Message(547745645645L, 1, 2, "WorldWorldWorldWorldWorldWorldWorldWorldWorldWorldWorldWorldWorldWorldWorldWorldWorldWorldWorldWorldWorldWorldWorldWorldWorldWorldWorldWorldWorldWorldWorldWorldWorld")

        chats.add(Chat(1, "Vasili", mutableListOf(message1, message2, message3)))
        chats.add(Chat(2, "Ivan", mutableListOf(message1, message2, message3)))
        chats.add(Chat(3, "Natasha", mutableListOf(message1, message2, message3)))
        chats.add(Chat(4, "Alex", mutableListOf(message1, message2, message3)))
        chats.add(Chat(5, "Nina", mutableListOf(message1, message2, message3)))
    }

    fun getChatById(idChat: Long) = chats.first { it.id == idChat }
}