package com.example.yomicepa.itemsScreen.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yomicepa.databinding.FragmentItemsBinding
import com.example.yomicepa.homeScreen.view.ReturnRequestAdapter
import com.example.yomicepa.itemsScreen.viewModel.ItemsViewModel
import com.example.yomicepa.itemsScreen.viewModel.ItemsViewModelFactory
import com.example.yomicepa.models.Item
import com.example.yomicepa.models.ReturnRequestListResponse
import com.example.yomicepa.network.APIState
import com.example.yomicepa.network.PharmacyClient
import com.example.yomicepa.network.RemoteDataSource
import com.example.yomicepa.repository.Repository
import com.example.yomicepa.repository.RepositoryInterface
import com.example.yomicepa.utilities.ApiToken
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

class ItemsFragment : Fragment() {
    private lateinit var itemsBinding: FragmentItemsBinding
    private lateinit var itemsViewModel: ItemsViewModel
    private lateinit var itemsAdapter: ItemsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        itemsBinding = FragmentItemsBinding.inflate(inflater)
        val itemFactory = ItemsViewModelFactory(
            Repository.getInstance(
                PharmacyClient.getInstance() as RemoteDataSource
            ) as RepositoryInterface, requireContext()
        )
        itemsViewModel = ViewModelProvider(this, itemFactory)[ItemsViewModel::class.java]
        val returnRequestID = arguments?.getInt("returnRequestID") as Int
        itemsViewModel.findAllItemsInReturnRequest(ApiToken.pharmacyId,returnRequestID,ApiToken.bearerToken)
        return itemsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        resultRequestListObservation()
    }
    private fun resultRequestListObservation(){
        lifecycleScope.launch {
            itemsViewModel.itemsList.collect { result ->
                when (result) {
                    is APIState.Loading -> {
                        Snackbar.make(requireView(), "loading in item Screen ", Snackbar.LENGTH_SHORT)
                            .show()
                    }
                    is APIState.Success<*> -> {
                        val itemList = result.data as List<Item>
                        if(itemList.isNotEmpty()){
                            itemsBinding.noItemsFoundLabel.visibility = View.GONE
                            itemsAdapter = ItemsAdapter(itemList)
                            itemsBinding.itemRv.adapter = itemsAdapter
                            itemsBinding.itemRv.layoutManager = GridLayoutManager(requireContext(), 2)
                        }else{
                            itemsBinding.noItemsFoundLabel.visibility = View.VISIBLE
                        }

                    }
                    is APIState.Failure -> {
                        Snackbar.make(requireView(), "failed in item Screen", Snackbar.LENGTH_SHORT)
                            .show()
                        Log.i("Esssss", result.error.toString())
                    }
                }
            }
        }

    }
}