package ru.mertsalovda.messager.ui.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.mertsalovda.messager.App
import ru.mertsalovda.messager.data.LoginRepository
import ru.mertsalovda.messager.data.model.LoggedInUser
import javax.inject.Inject

class ProfileViewModel : ViewModel() {

    @Inject
    lateinit var loginRepository: LoginRepository

    private val _loggedInUser = MutableLiveData<LoggedInUser>()
    val logginInUser: MutableLiveData<LoggedInUser> = _loggedInUser

    init {
        App.appScopo.inject(this)
    }

    fun load(){
        logginInUser.postValue(loginRepository.user)
    }

    fun logout() {
        loginRepository.logout()
    }


}