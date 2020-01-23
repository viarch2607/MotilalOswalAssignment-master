package com.example.motilaloswalassignment

import android.app.Application
import com.example.motilaloswalassignment.di.repositoryModule
import com.example.motilaloswalassignment.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class LoginApplication : Application() {
    override fun onCreate() {
        super.onCreate()



        startKoin {
            androidLogger()
            androidContext(this@LoginApplication)
            modules(listOf(repositoryModule, viewModelModule))
        }


    }
}