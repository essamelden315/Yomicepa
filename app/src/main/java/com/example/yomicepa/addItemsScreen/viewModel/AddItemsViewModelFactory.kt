package com.example.yomicepa.addItemsScreen.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.yomicepa.login.viewModel.LoginViewModel
import com.example.yomicepa.repository.RepositoryInterface

class AddItemsViewModelFactory (private val repoInterface: RepositoryInterface): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(AddItemsViewModel::class.java)) {
            AddItemsViewModel(repoInterface) as T
        } else {
            throw IllegalArgumentException("ViewModel Class not found")
        }
    }
}