package com.example.yomicepa.itemsScreen.viewModel

import androidx.lifecycle.ViewModel
import com.example.yomicepa.repository.RepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class ItemsViewModel @Inject constructor(private val repo: RepositoryInterface): ViewModel() {
}