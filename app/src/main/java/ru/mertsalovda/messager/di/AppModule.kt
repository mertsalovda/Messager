package ru.mertsalovda.messager.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.mertsalovda.messager.data.LoginDataSource
import ru.mertsalovda.messager.data.LoginRepository
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideContext() = context

    @Provides
    @Singleton
    fun provideLoginRepository() = LoginRepository(LoginDataSource())
}