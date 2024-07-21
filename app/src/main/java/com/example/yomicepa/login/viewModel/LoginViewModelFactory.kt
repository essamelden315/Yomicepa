package com.example.yomicepa.login.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.yomicepa.repository.RepositoryInterface

class LoginViewModelFactory(private val repoInterface: RepositoryInterface) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            LoginViewModel(repoInterface) as T
        } else {
            throw IllegalArgumentException("ViewModel Class not found")
        }
    }
}