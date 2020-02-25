package ru.mertsalovda.messager.ui.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.mertsalovda.messager.App
import ru.mertsalovda.messager.data.DataBase
import ru.mertsalovda.messager.data.model.UserLogin
import javax.inject.Inject

class ProfileViewModel : ViewModel() {

    @Inject
    lateinit var database: DataBase

    private val _loggedInUser = MutableLiveData<UserLogin>()
    val loginInUserLogin: MutableLiveData<UserLogin> = _loggedInUser

    init {
        App.appScope.inject(this)
    }

    fun load(){
        val userLogin = database.userLoginDao().getUserLogin().first()
        loginInUserLogin.postValue(userLogin)
    }

    fun logout() {
    }


}