package com.shubham.mvvmwithdagger.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shubham.mvvmwithdagger.model.Product
import com.shubham.mvvmwithdagger.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ProductRepository) : ViewModel() {

    val productData : LiveData<List<Product>>
    get() = repository.productData

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getProduct()
        }
    }

}