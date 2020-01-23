package com.example.motilaloswalassignment.di

import com.example.motilaloswalassignment.repository.LoginRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module



val repositoryModule = module {
    single { LoginRepository() }

}