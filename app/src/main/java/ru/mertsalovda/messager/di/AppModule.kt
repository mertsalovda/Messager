package ru.mertsalovda.messager.di

import ru.mertsalovda.messager.data.LoginDataSource
import ru.mertsalovda.messager.data.LoginRepository
import toothpick.config.Module
import toothpick.ktp.binding.bind

class AppModule() : Module() {

    init {
        bind<LoginRepository>().toInstance(provideLoginRepository())
    }
    fun provideLoginRepository() = LoginRepository(LoginDataSource())
}