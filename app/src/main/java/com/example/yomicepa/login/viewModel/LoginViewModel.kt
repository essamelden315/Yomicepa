package com.example.yomicepa.login.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yomicepa.models.LoginRequest
import com.example.yomicepa.network.APIState
import com.example.yomicepa.repository.RepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel (private val repo: RepositoryInterface,private val context: Context) : ViewModel() {
    private var _loginResponseData = MutableStateFlow<APIState>(APIState.Loading)
    var loginResponseData: StateFlow<APIState> = _loginResponseData

    private var _pharmacyResponseList = MutableStateFlow<APIState>(APIState.Loading)
    var pharmacyResponseList: StateFlow<APIState> = _pharmacyResponseList

    fun login(loginRequest: LoginRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.login(loginRequest).catch { e ->
                _loginResponseData.value = APIState.Failure(e)
            }.collect {
                _loginResponseData.value = APIState.Success(it.body())
            }
        }
    }

    fun findAllPharmacies(tokenHeader: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.findAllPharmacies(tokenHeader).catch{e->
                _pharmacyResponseList.value = APIState.Failure(e)
            }.collect{
                _pharmacyResponseList.value =  APIState.Success(it.body())
            }
        }

    }
}
