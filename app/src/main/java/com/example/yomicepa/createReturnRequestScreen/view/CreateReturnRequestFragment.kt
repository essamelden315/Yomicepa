package com.example.yomicepa.createReturnRequestScreen.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yomicepa.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateReturnRequestFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_return_request, container, false)
    }

}