package com.shubham.mvvmwithdagger.api

import com.shubham.mvvmwithdagger.model.Product
import retrofit2.Response
import retrofit2.http.GET

interface ProductService {
    @GET("products")
    suspend fun getProductFromServer() : Response<List<Product>>
}