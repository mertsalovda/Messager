package ru.mertsalovda.messager.ui.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.mertsalovda.messager.App
import ru.mertsalovda.messager.data.model.UserLoggin
import javax.inject.Inject

class ProfileViewModel : ViewModel() {

    @Inject
    lateinit var loginRepository: LoginRepository

    private val _loggedInUser = MutableLiveData<UserLoggin>()
    val logginInUserLoggin: MutableLiveData<UserLoggin> = _loggedInUser

    init {
        App.appScopo.inject(this)
    }

    fun load(){
        logginInUserLoggin.postValue(loginRepository.userLoggin)
    }

    fun logout() {
        loginRepository.logout()
    }


}