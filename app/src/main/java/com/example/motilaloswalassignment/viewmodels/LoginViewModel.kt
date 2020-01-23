package com.example.motilaloswalassignment.viewmodels

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.motilaloswalassignment.repository.LoginRepository
import com.example.motilaloswalassignment.util.Utils

class LoginViewModel() : ViewModel() {

    private val loginRepository: LoginRepository


    init {
        loginRepository = LoginRepository()

    }

    fun isValidUseridandPassword(userId: String, password : String): Boolean {
        if (Utils.isFieldEmpty(userId) || Utils.isFieldEmpty(password)) {
            return false
        }
        return true
    }

    fun validateInputs(userId: String, password: String): LiveData<String> {
        return loginRepository.validateInputs(userId, password)
    }


}