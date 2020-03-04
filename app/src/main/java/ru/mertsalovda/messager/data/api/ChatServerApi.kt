package ru.mertsalovda.messager.data.api

import io.reactivex.Single
import retrofit2.http.GET
import ru.mertsalovda.messager.data.model.User

interface ChatServerApi {

    @GET("users")
    fun getUsers(): Single<List<User>>
}