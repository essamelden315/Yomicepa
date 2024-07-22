package com.example.yomicepa.login.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.yomicepa.repository.RepositoryInterface

class LoginViewModelFactory(private val repoInterface: RepositoryInterface,private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            LoginViewModel(repoInterface,context) as T
        } else {
            throw IllegalArgumentException("ViewModel Class not found")
        }
    }
}