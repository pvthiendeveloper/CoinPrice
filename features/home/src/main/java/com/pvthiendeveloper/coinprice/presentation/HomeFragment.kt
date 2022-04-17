package com.pvthiendeveloper.coinprice.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.pvthiendeveloper.coinprice.home.databinding.FragmentHomeBinding
import com.pvthiendeveloper.coinprice.presentation.controller.HomeController
import com.pvthiendeveloper.coinprice.presentation.views.decoration.ItemDecoration
import com.pvthiendeveloper.coinprice.showSnackBar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.distinctUntilChangedBy
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    @Inject
    internal lateinit var controller: HomeController

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
            controller.refresh()
        }
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewModel.errorMessage.collectLatest {
                if (it.isNotEmpty()) {
                    showSnackBar(it)
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewModel.fetchListCrypto()
                .distinctUntilChanged()
                .collectLatest {
                    controller.submitData(it)
                }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            controller.loadStateFlow
                .distinctUntilChangedBy { it.refresh }
                .collectLatest {
                    controller.showLoading(it.refresh is LoadState.Loading)
                }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            controller.loadStateFlow
                .distinctUntilChangedBy { it.refresh }
                .collectLatest {
                    val refresh = it.refresh
                    if (refresh is LoadState.Error) {
                        viewModel.handleError(refresh.error)
                    }
                }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}