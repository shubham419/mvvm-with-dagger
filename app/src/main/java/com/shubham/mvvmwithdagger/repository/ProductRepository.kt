package com.shubham.mvvmwithdagger.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shubham.mvvmwithdagger.api.ProductService
import com.shubham.mvvmwithdagger.model.Product
import javax.inject.Inject

class ProductRepository @Inject constructor(private val productService: ProductService) {

    private val _product =  MutableLiveData<List<Product>>()

    val productData: LiveData<List<Product>>
    get() = _product

    suspend fun getProduct(){
        val result = productService.getProductFromServer()
        if(result.isSuccessful && result.body()!=null){
        _product.postValue(result.body())
        }
    }
}