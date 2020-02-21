package ru.mertsalovda.messager.di

import android.content.Context
import androidx.room.Room
import ru.mertsalovda.messager.data.DataBase
import toothpick.config.Module
import toothpick.ktp.binding.bind

class AppModule(private val context: Context) : Module() {

    init {
        bind(DataBase::class).toInstance(provideDataBase())
    }

    private fun provideDataBase(): DataBase{
        return Room.databaseBuilder(context, DataBase::class.java, "database").build()
    }
}