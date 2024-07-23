package com.example.yomicepa.homeScreen.viewModel

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

class HomeScreenViewModel (private val repo: RepositoryInterface,private val context: Context): ViewModel(){
    private var _resultReauestList = MutableStateFlow<APIState>(APIState.Loading)
    var resultReauestList: StateFlow<APIState> = _resultReauestList
    fun findAllReturnRequestByPharmacyId(pharmacyId:Int, authHeader:String) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.findAllReturnRequestByPharmacyId(pharmacyId,authHeader).catch { e ->
                _resultReauestList.value = APIState.Failure(e)
            }.collect {
                _resultReauestList.value = APIState.Success(it.body())
            }
        }
    }

}