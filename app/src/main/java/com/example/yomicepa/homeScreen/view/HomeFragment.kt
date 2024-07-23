package com.example.yomicepa.homeScreen.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yomicepa.R
import com.example.yomicepa.databinding.FragmentHomeBinding
import com.example.yomicepa.homeScreen.viewModel.HomeScreenViewModel
import com.example.yomicepa.homeScreen.viewModel.HomeScreenViewModelFactory
import com.example.yomicepa.models.ReturnRequestListResponse
import com.example.yomicepa.network.APIState
import com.example.yomicepa.network.PharmacyClient
import com.example.yomicepa.network.RemoteDataSource
import com.example.yomicepa.repository.Repository
import com.example.yomicepa.repository.RepositoryInterface
import com.example.yomicepa.utilities.ApiToken
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch


class HomeFragment : Fragment(),Delegation {
    private lateinit var homeBinding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeScreenViewModel
    private lateinit var returnRequestAdapter: ReturnRequestAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.setTitle("home")
        homeBinding = FragmentHomeBinding.inflate(inflater)
        val homeFactory = HomeScreenViewModelFactory(
            Repository.getInstance(
                PharmacyClient.getInstance() as RemoteDataSource
            ) as RepositoryInterface, requireContext()
        )
        homeViewModel = ViewModelProvider(this, homeFactory)[HomeScreenViewModel::class.java]
        homeViewModel.findAllReturnRequestByPharmacyId(ApiToken.pharmacyId,ApiToken.bearerToken)
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        resultRequestListObservation()
        homeBinding.createRequestBtn.setOnClickListener{
            Navigation.findNavController(requireView())
                .navigate(R.id.action_homeFragment_to_createReturnRequestFragment)
        }
    }

    private fun resultRequestListObservation(){
        lifecycleScope.launch {
            homeViewModel.resultReauestList.collect { result ->
                when (result) {
                    is APIState.Loading -> {
                        Snackbar.make(requireView(), "loading in home Screen ", Snackbar.LENGTH_SHORT)
                            .show()
                    }
                    is APIState.Success<*> -> {
                        val returnRequestListResponse = (result.data as ReturnRequestListResponse)
                        returnRequestAdapter = ReturnRequestAdapter(returnRequestListResponse,this@HomeFragment)
                        homeBinding.returnRequestRV.adapter = returnRequestAdapter
                        homeBinding.returnRequestRV.layoutManager = LinearLayoutManager(context)
                    }
                    is APIState.Failure -> {
                        Snackbar.make(requireView(), "failed in login", Snackbar.LENGTH_SHORT)
                            .show()
                        Log.i("Esssss", result.error.toString())
                    }
                }
            }
        }

    }

    override fun gotoItemsScreen(returnRequestID: Int) {
        val bundle = Bundle().apply {
            putInt("returnRequestID",returnRequestID)
        }
        Navigation.findNavController(requireView()).navigate(R.id.action_homeFragment_to_itemsFragment,bundle)
    }


}