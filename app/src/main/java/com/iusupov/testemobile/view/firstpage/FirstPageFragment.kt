package com.iusupov.testemobile.view.firstpage

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.iusupov.common.utils.wrapper.DataResult
import com.iusupov.presentation.viewmodel.FirstPageViewModel
import com.iusupov.testemobile.databinding.FragmentFirstPageBinding
import com.iusupov.testemobile.utils.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstPageFragment :
    BaseFragment<FragmentFirstPageBinding>(FragmentFirstPageBinding::inflate) {

        private val viewModel: FirstPageViewModel by viewModels()
        private lateinit var firstPageCategoryAdapter: FirstPageCategoryAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.latestProduct.observe(viewLifecycleOwner) { response ->

            when (response) {
                is DataResult.Success -> {
                    firstPageCategoryAdapter.differ.submitList(response.data.latest)
                }
                is DataResult.Error -> {
                    Toast.makeText(activity, "Произошла ошибка: $response", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
        setupLatestRecyclerView()
    }

    private fun setupLatestRecyclerView() {
        firstPageCategoryAdapter = FirstPageCategoryAdapter()
        binding.rvLatest.apply {
            adapter = firstPageCategoryAdapter
        }
    }
}