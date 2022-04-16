package com.pvthiendeveloper.coinprice.home.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.pvthiendeveloper.coinprice.home.databinding.FragmentHomeBinding
import com.pvthiendeveloper.coinprice.home.presentation.controller.HomeController
import com.pvthiendeveloper.coinprice.home.presentation.model.HomeUiState
import com.pvthiendeveloper.coinprice.home.presentation.views.decoration.ItemDecoration
import com.pvthiendeveloper.ui.gone
import com.pvthiendeveloper.ui.show
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
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
        binding.recyclerView.addItemDecoration(ItemDecoration())
        binding.swipeLayout.setOnRefreshListener {
            binding.swipeLayout.isRefreshing = false
            viewModel.fetchListCrypto()
        }
        viewModel.fetchListCrypto()
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewModel.homeUiState.collectLatest {
                updateScreen(it)
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    @SuppressLint("ShowToast")
    private fun updateScreen(uiState: HomeUiState) {
        if (!uiState.message.isNullOrEmpty()) {
            Toast.makeText(requireContext(), uiState.message, Toast.LENGTH_LONG).show()
        }

        if (uiState.cryptos.isNotEmpty()) {
            controller.setData(uiState.cryptos)
        }
    }
}