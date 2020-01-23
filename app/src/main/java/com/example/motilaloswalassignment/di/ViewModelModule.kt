package com.example.motilaloswalassignment.di


import com.example.motilaloswalassignment.viewmodels.LoginViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { LoginViewModel() }

}
