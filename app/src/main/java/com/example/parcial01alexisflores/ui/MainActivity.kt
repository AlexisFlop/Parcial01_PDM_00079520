package com.example.parcial01alexisflores.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.parcial01alexisflores.R
import com.example.parcial01alexisflores.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}