package ru.mertsalovda.messager.data

import ru.mertsalovda.messager.data.model.LoggedInUser
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String): Result<LoggedInUser> {
        return try {
            // TODO: handle loggedInUser authentication
            val fakeUser = LoggedInUser(
                java.util.UUID.randomUUID().toString(),
                "Jane Doe",
                "dsaf4sdfds54f4dsf",
                ""
            )
            Result.Success(fakeUser)
        } catch (e: Throwable) {
            Result.Error(IOException("Ошибка входа", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}

