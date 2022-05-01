package com.shubham.mvvmwithdagger

import android.app.Application
import com.shubham.mvvmwithdagger.dependencyInjection.ApplicationComponent
import com.shubham.mvvmwithdagger.dependencyInjection.DaggerApplicationComponent
import dagger.Component

class ProductApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder().build()
    }
}