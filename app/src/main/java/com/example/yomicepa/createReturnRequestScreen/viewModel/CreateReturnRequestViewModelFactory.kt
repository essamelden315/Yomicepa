package com.example.yomicepa.createReturnRequestScreen.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.yomicepa.repository.RepositoryInterface

class CreateReturnRequestViewModelFactory(private val repoInterface: RepositoryInterface): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(CreateReturnRequestViewModel::class.java)) {
            CreateReturnRequestViewModel(repoInterface) as T
        } else {
            throw IllegalArgumentException("ViewModel Class not found")
        }
    }
}