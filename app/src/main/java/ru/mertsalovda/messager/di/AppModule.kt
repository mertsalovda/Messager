package ru.mertsalovda.messager.di

import ru.mertsalovda.messager.data.LoginDataSource
import ru.mertsalovda.messager.data.LoginRepository
import toothpick.config.Module
import toothpick.ktp.binding.bind

class AppModule : Module() {

    private val loginRepository = provideLoginRepository()

    init {
        bind<LoginRepository>().toInstance(loginRepository)
    }
    fun provideLoginRepository() = LoginRepository(LoginDataSource())
}