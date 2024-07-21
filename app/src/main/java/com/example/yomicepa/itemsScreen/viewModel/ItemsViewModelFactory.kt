package com.example.yomicepa.itemsScreen.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.yomicepa.repository.RepositoryInterface

class ItemsViewModelFactory(private val repoInterface: RepositoryInterface) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ItemsViewModel::class.java)) {
            ItemsViewModel(repoInterface) as T
        } else {
            throw IllegalArgumentException("ViewModel Class not found")
        }
    }
}