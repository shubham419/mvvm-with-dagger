package com.shubham.mvvmwithdagger.dependencyInjection

import com.shubham.mvvmwithdagger.api.ProductService
import com.shubham.mvvmwithdagger.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit) : ProductService {
        return retrofit.create(ProductService::class.java)
    }

}