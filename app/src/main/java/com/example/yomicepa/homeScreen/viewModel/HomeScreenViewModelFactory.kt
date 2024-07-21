package com.example.yomicepa.homeScreen.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.yomicepa.repository.RepositoryInterface

class HomeScreenViewModelFactory(private val repoInterface: RepositoryInterface): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(HomeScreenViewModel::class.java)) {
            HomeScreenViewModel(repoInterface) as T
        } else {
            throw IllegalArgumentException("ViewModel Class not found")
        }
    }
}