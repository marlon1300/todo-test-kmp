package com.todo.app.android

import android.app.Application
import com.todo.app.di.initKoin
import org.koin.android.ext.koin.androidContext

class ToDoApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@ToDoApp)
        }
    }
}