package ru.mertsalovda.messager.di

import dagger.Component
import ru.mertsalovda.messager.data.LoginRepository
import ru.mertsalovda.messager.ui.login.LoginFragment
import ru.mertsalovda.messager.ui.login.LoginViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(injector: LoginFragment)
    fun inject(injector: LoginViewModel)
    fun getLoginRepository(): LoginRepository
}