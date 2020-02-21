package ru.mertsalovda.messager

import android.app.Application
import ru.mertsalovda.messager.di.AppModule
import toothpick.Scope
import toothpick.Toothpick

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        appScopo = Toothpick.openScope(Application::class.java).installModules(AppModule(applicationContext))
    }

    companion object {
        lateinit var appScopo: Scope
    }
}