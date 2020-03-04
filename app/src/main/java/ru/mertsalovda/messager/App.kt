package ru.mertsalovda.messager

import android.app.Application
import ru.mertsalovda.messager.di.AppModule
import ru.mertsalovda.messager.di.NetworkModule
import toothpick.Scope
import toothpick.Toothpick

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        appScope = Toothpick.openScope(Application::class.java)
            .installModules(AppModule(applicationContext), NetworkModule())
    }

    companion object {
        lateinit var appScope: Scope
    }
}