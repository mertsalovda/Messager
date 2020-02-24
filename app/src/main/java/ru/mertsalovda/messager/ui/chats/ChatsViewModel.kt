package ru.mertsalovda.messager.ui.chats

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.mertsalovda.messager.App
import ru.mertsalovda.messager.data.DataBase
import ru.mertsalovda.messager.data.model.Chat
import javax.inject.Inject

class ChatsViewModel : ViewModel() {

    @Inject
    lateinit var database: DataBase

    init{
        App.appScope.inject(this)
    }

    private val _chats = MutableLiveData<List<Chat>>()
    val chats: MutableLiveData<List<Chat>> = _chats

    fun load(){
        val allChats = database.chatsDao().getAllChats()
        chats.postValue(allChats)
    }


}