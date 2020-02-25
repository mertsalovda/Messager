package ru.mertsalovda.messager.ui.chat

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.mertsalovda.messager.App
import ru.mertsalovda.messager.data.DataBase
import ru.mertsalovda.messager.data.model.ChatAndMessages
import ru.mertsalovda.messager.data.model.Message
import java.util.*
import javax.inject.Inject

class ChatViewModel : ViewModel() {

    @Inject
    lateinit var database: DataBase

    init {
        App.appScope.inject(this)
    }

    private lateinit var chatAndMessages: ChatAndMessages
    private val _messages = MutableLiveData<List<Message>>()
    val messages: MutableLiveData<List<Message>> = _messages

    private val _chatName = MutableLiveData<String>()
    val chatName: MutableLiveData<String> = _chatName

    fun load(chatId: Long) {
        chatAndMessages = database.chatsDao().getChatWithMessagesById(chatId).first()
        chatName.postValue(chatAndMessages.chat.name)
        val allMessages = chatAndMessages.messages
        messages.postValue(allMessages)
    }

    fun sendMessage(message: String) {
        val userLogin = database.userLoginDao().getUserLogin().first()
        val m = Message(
            messageId = 0,
            ownerId = chatAndMessages.chat.chatId,
            senderUid = userLogin.uid,
            targetUid = chatAndMessages.chat.userUid,
            senderName = userLogin.name,
            date = Date().time,
            text = message
        )
        database.messagesDao().insertMessage(m)
    }
}