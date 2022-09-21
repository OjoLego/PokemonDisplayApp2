package com.example.pokemondisplayapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokemondisplayapp2.databinding.ActivityMainBinding
import com.example.pokemondisplayapp2.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var ViewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onDestroy() {
        super.onDestroy()
        ViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        ViewModel.cancelJob()
    }

}