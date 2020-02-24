package ru.mertsalovda.messager.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.mertsalovda.messager.App
import ru.mertsalovda.messager.data.DataBase
import ru.mertsalovda.messager.data.model.UserLogin
import javax.inject.Inject

class MainViewModel : ViewModel() {

    private var username: String

    @Inject
    lateinit var database: DataBase

    private val _loggedInUser = MutableLiveData<UserLogin>()
    val loginInUserLogin: MutableLiveData<UserLogin> = _loggedInUser

    init {
        // In this example, the user is always unauthenticated when MainActivity is launched
        authenticationState.value = AuthenticationState.AUTHENTICATED
        username = ""
        App.appScope.inject(this)
        database.userLoginDao().insertUserLogin(UserLogin(1, 123, "Dmitriy", "Nothing", "TOKEN"))
    }

    fun refuseAuthentication() {
        authenticationState.value = AuthenticationState.UNAUTHENTICATED
    }

    fun authenticate(username: String, password: String) {
        if (passwordIsValidForUsername(username, password)) {
            this.username = username
            authenticationState.value = AuthenticationState.AUTHENTICATED
        } else {
            authenticationState.value = AuthenticationState.INVALID_AUTHENTICATION
        }
    }

    private fun passwordIsValidForUsername(username: String, password: String): Boolean {
        return true
    }

    fun authState() {
    }

    companion object {

        val authenticationState = MutableLiveData<AuthenticationState>()

        fun setAuthState(state: AuthenticationState) {
            authenticationState.postValue(state)
        }
    }

}


enum class AuthenticationState {
    UNAUTHENTICATED,
    AUTHENTICATED,
    INVALID_AUTHENTICATION
}
