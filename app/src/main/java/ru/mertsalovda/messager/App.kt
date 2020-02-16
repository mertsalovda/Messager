package ru.mertsalovda.messager

import android.app.Application
import ru.mertsalovda.messager.di.AppComponent
import ru.mertsalovda.messager.di.AppModule
import ru.mertsalovda.messager.di.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()

    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}