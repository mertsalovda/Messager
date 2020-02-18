package ru.mertsalovda.messager.ui.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.mertsalovda.messager.data.ChatRepository
import ru.mertsalovda.messager.data.model.Message

class ChatViewModel : ViewModel() {

    private val chatRepository = ChatRepository()

    private val _text = MutableLiveData<String>().apply {
        value = "This is Chat Fragment"
    }

    fun loadMessage(idChat: Long): MutableList<Message> = chatRepository.getChatById(idChat).messages
    val text: LiveData<String> = _text
}