package ru.mertsalovda.messager.ui.chat

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.mertsalovda.messager.App
import ru.mertsalovda.messager.data.DataBase
import ru.mertsalovda.messager.data.model.Message
import javax.inject.Inject

class ChatViewModel : ViewModel() {

    @Inject
    lateinit var database: DataBase

    init{
        App.appScope.inject(this)
    }

    private val _messages = MutableLiveData<List<Message>>()
    val messages: MutableLiveData<List<Message>> = _messages

    private val _chatName = MutableLiveData<String>()
    val chatName: MutableLiveData<String> = _chatName

    fun load(chatId: Long){
        val chat = database.chatsDao().getChatById(chatId)
        chatName.postValue(chat.name)
        val allMessages = database.messagesDao().getAllMessageByChatId(chatId)
        messages.postValue(allMessages)
    }
}