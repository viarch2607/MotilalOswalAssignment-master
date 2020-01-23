package com.example.motilaloswalassignment.repository


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.motilaloswalassignment.util.Constants

class LoginRepository (){
    fun validateInputs(userId: String, password: String): LiveData<String> {
        val data = MutableLiveData<String>()

        if(userId.equals(password)){
            data.value = Constants.ACTION_SUCCESS_MSG
        }else{
            data.value = Constants.ACTION_ERROR_MSG
        }
        return data
    }
}