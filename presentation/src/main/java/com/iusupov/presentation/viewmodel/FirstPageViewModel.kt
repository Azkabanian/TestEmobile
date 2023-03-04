package com.iusupov.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iusupov.common.utils.wrapper.DataResult
import com.iusupov.domain.model.FlashSaleResponseDomainModule
import com.iusupov.domain.model.LatestResponseDomainModule
import com.iusupov.domain.usecase.flashsale.FlashSaleUseCase
import com.iusupov.domain.usecase.latestproduct.LatestProductUseCase
import kotlinx.coroutines.launch

class FirstPageViewModel(
    private val latestProductUseCase: LatestProductUseCase,
    private val flashSaleUseCase: FlashSaleUseCase
) : ViewModel() {

    private val _latestProduct = MutableLiveData<DataResult<LatestResponseDomainModule>>()
    val latestProduct: LiveData<DataResult<LatestResponseDomainModule>>
        get() = _latestProduct

    private val _flashSale = MutableLiveData<DataResult<FlashSaleResponseDomainModule>>()
    val flashSale: LiveData<DataResult<FlashSaleResponseDomainModule>>
        get() = _flashSale

    fun fetchLatestProduct(): LiveData<DataResult<LatestResponseDomainModule>> {
        viewModelScope.launch {
            when (val result = latestProductUseCase.invoke()) {
                is DataResult.Success -> DataResult.Success(
                    _latestProduct.postValue(result)
                )
                is DataResult.Error -> DataResult.Error(result.exception)
            }
        }
        return _latestProduct
    }

    fun fetchFlashSale(): LiveData<DataResult<FlashSaleResponseDomainModule>> {
        viewModelScope.launch {
            when (val result = flashSaleUseCase.invoke()) {
                is DataResult.Success -> DataResult.Success(
                    _flashSale.postValue(result)
                )
                is DataResult.Error -> DataResult.Error(result.exception)
            }
        }
        return _flashSale
    }

}