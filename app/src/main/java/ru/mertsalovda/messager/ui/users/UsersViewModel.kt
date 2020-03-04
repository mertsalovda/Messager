package ru.mertsalovda.messager.ui.users

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.mertsalovda.messager.App
import ru.mertsalovda.messager.data.DataBase
import ru.mertsalovda.messager.data.api.ChatServerApi
import ru.mertsalovda.messager.data.model.Chat
import ru.mertsalovda.messager.data.model.User
import javax.inject.Inject

class UsersViewModel : ViewModel() {

    @Inject
    lateinit var database: DataBase
    @Inject
    lateinit var api: ChatServerApi

    init {
        App.appScope.inject(this)
    }

    private val _users = MutableLiveData<List<User>>()
    val users: MutableLiveData<List<User>> = _users

    fun load() {
//        val allUsers = database.usersDao().getAllUsers()
//        users.postValue(allUsers)
        api.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ users.postValue(it) }, {})
    }

    fun createNewChatWithUser(user: User): Chat {
        val chatByUserUid = database.chatsDao().getChatByUserUid(user.uid)
        if (chatByUserUid != null) {
            return chatByUserUid
        }
        val chat = Chat(0, user.uid, user.name, 0)
        database.chatsDao().insertChat(chat)
        return database.chatsDao().getChatByUserUid(user.uid)!!
    }
}