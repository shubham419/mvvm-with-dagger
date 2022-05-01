package com.shubham.mvvmwithdagger.dependencyInjection

import com.shubham.mvvmwithdagger.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {
    fun insert(mainActivity: MainActivity)
}