package com.example.yomicepa.homeScreen.viewModel

import androidx.lifecycle.ViewModel
import com.example.yomicepa.repository.RepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class HomeScreenViewModel @Inject constructor(private val repo: RepositoryInterface): ViewModel() {
}