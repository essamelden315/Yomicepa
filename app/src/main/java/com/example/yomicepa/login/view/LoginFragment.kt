package com.example.yomicepa.login.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.yomicepa.R
import com.example.yomicepa.databinding.FragmentLoginBinding
import com.example.yomicepa.login.viewModel.LoginViewModel
import com.example.yomicepa.login.viewModel.LoginViewModelFactory
import com.example.yomicepa.models.LoginRequest
import com.example.yomicepa.models.LoginResponse
import com.example.yomicepa.models.PharmacyListResponse
import com.example.yomicepa.network.APIState
import com.example.yomicepa.network.PharmacyClient
import com.example.yomicepa.network.RemoteDataSource
import com.example.yomicepa.repository.Repository
import com.example.yomicepa.repository.RepositoryInterface
import com.example.yomicepa.utilities.ApiToken
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {
    private lateinit var loginBinding: FragmentLoginBinding
    private lateinit var loginViewModel: LoginViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginBinding = FragmentLoginBinding.inflate(inflater)
        return loginBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val loginFactory = LoginViewModelFactory(
            Repository.getInstance(
                PharmacyClient.getInstance() as RemoteDataSource
            ) as RepositoryInterface, requireContext()
        )
        loginViewModel = ViewModelProvider(this, loginFactory)[LoginViewModel::class.java]
    }

    override fun onResume() {
        super.onResume()
        loginBinding.loginButton.setOnClickListener {
            Log.i("Esssss", loginBinding.email.text.toString())
            Log.i("Esssss", loginBinding.password.text.toString())
            loginViewModel.login(
                LoginRequest(
                    loginBinding.email.text.toString(),
                    loginBinding.password.text.toString()
                )

            )
            loginResponseObservation()
        }
    }

    private fun loginResponseObservation() {
        lifecycleScope.launch {
            loginViewModel.loginResponseData.collect { result ->
                when (result) {
                    is APIState.Loading -> {
                        Snackbar.make(requireView(), "loading in login ", Snackbar.LENGTH_SHORT)
                            .show()
                    }

                    is APIState.Success<*> -> {

                        val loginResponse = (result.data as LoginResponse)
                        ApiToken.token = loginResponse.token ?:""
                        ApiToken.bearerToken = "Bearer ${ApiToken.token}"
                        loginViewModel.findAllPharmacies(ApiToken.bearerToken)
                        pharmaciesListResponseObservation()
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

    private fun pharmaciesListResponseObservation() {
        lifecycleScope.launch {
            loginViewModel.pharmacyResponseList.collect { result ->
                when (result) {
                    is APIState.Loading -> {
                        Snackbar.make(requireView(), "loading in pharm", Snackbar.LENGTH_SHORT)
                            .show()
                    }

                    is APIState.Success<*> -> {
                        val pharmacyListResponse = result.data as List<PharmacyListResponse>
                        ApiToken.pharmacyId = pharmacyListResponse[0].pharmacyId
                        Navigation.findNavController(requireView())
                            .navigate(R.id.action_loginFragment_to_homeFragment)
                    }

                    is APIState.Failure -> {
                        Snackbar.make(requireView(), "failed in pharm", Snackbar.LENGTH_SHORT)
                            .show()
                        Log.i("Esssss", result.error.toString())
                    }
                }
            }
        }
    }
}