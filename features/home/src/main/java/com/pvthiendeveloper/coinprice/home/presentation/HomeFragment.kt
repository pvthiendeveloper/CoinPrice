package com.pvthiendeveloper.coinprice.home.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.pvthiendeveloper.coinprice.home.databinding.FragmentHomeBinding
import com.pvthiendeveloper.coinprice.home.presentation.controller.HomeController
import com.pvthiendeveloper.navigation.deeplink.DeepLinkDetail
import com.pvthiendeveloper.navigation.extension.navigate
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    @Inject
    lateinit var controller: HomeController

    private val viewModel: HomeViewModel by viewModels()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = controller.adapter
        viewModel.fetchListCrypto()
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewModel.homeUiState.collectLatest {
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}