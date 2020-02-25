package ru.mertsalovda.messager.di

import android.content.Context
import androidx.room.Room
import ru.mertsalovda.messager.data.DataBase
import toothpick.config.Module
import toothpick.ktp.binding.bind

class AppModule(private val context: Context) : Module() {

    private val dataBase = provideDataBase()

    init {
        bind(DataBase::class).toInstance(dataBase)
    }

    private fun provideDataBase(): DataBase {
        return Room.databaseBuilder(context, DataBase::class.java, "database1.db")
            .allowMainThreadQueries()
            .build()
    }
}