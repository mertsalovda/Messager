package ru.mertsalovda.messager.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.mertsalovda.messager.App
import ru.mertsalovda.messager.data.LoginRepository
import ru.mertsalovda.messager.data.model.LoggedInUser
import javax.inject.Inject

class MainViewModel : ViewModel() {

    @Inject
    lateinit var loginRepository: LoginRepository

    var username: String

    private val _loggedInUser = MutableLiveData<LoggedInUser>()
    val logginInUser: MutableLiveData<LoggedInUser> = _loggedInUser

    init {
        // In this example, the user is always unauthenticated when MainActivity is launched
        authenticationState.value = AuthenticationState.UNAUTHENTICATED
        username = ""
        App.appScopo.inject(this)
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
        logginInUser.postValue(loginRepository.user)
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
