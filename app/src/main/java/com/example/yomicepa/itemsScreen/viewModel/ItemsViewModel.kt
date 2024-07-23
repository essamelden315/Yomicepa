package com.example.yomicepa.itemsScreen.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yomicepa.network.APIState
import com.example.yomicepa.repository.RepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject
class ItemsViewModel (private val repo: RepositoryInterface,private val context: Context): ViewModel() {
    private var _itemsList = MutableStateFlow<APIState>(APIState.Loading)
    var itemsList: StateFlow<APIState> = _itemsList
    fun findAllItemsInReturnRequest(pharmacyId:Int,returnRequest:Int, authHeader:String) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.findAllItemsInReturnRequest(pharmacyId,returnRequest,authHeader).catch { e ->
                _itemsList.value = APIState.Failure(e)
            }.collect {
                _itemsList.value = APIState.Success(it.body())
            }
        }
    }
}