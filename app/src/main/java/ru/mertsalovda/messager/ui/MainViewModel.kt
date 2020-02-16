package ru.mertsalovda.messager.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {


    var username: String

    init {
        // In this example, the user is always unauthenticated when MainActivity is launched
        authenticationState.value = AuthenticationState.UNAUTHORIZED
        username = ""
    }

    fun refuseAuthentication() {
        authenticationState.value = AuthenticationState.UNAUTHORIZED
    }

    fun authenticate(username: String, password: String) {
        if (passwordIsValidForUsername(username, password)) {
            this.username = username
            authenticationState.value = AuthenticationState.AUTHORIZED
        } else {
            authenticationState.value = AuthenticationState.INVALID_AUTHORIZATION
        }
    }

    private fun passwordIsValidForUsername(username: String, password: String): Boolean {
        return true
    }

    fun authState() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {

        val authenticationState = MutableLiveData<AuthenticationState>()

        fun setAuthState(state: AuthenticationState) {
            authenticationState.postValue(state)
        }
    }

}


enum class AuthenticationState {
    UNAUTHORIZED,
    AUTHORIZED,
    INVALID_AUTHORIZATION
}
