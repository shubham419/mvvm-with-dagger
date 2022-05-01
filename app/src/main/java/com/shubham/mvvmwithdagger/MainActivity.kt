package com.shubham.mvvmwithdagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.shubham.mvvmwithdagger.viewModel.MainViewModel
import com.shubham.mvvmwithdagger.viewModel.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory
    val TextView : TextView
    get() = findViewById(R.id.text)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as ProductApplication).applicationComponent.insert(this)

        mainViewModel  = ViewModelProvider(this,mainViewModelFactory).get(MainViewModel::class.java)

        mainViewModel.productData.observe(this, {
           TextView.text =  it.joinToString { x -> x.title + "\n\n" }
        })

    }
}