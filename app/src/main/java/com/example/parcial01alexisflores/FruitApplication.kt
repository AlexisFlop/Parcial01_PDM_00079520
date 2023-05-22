package com.example.parcial01alexisflores

import android.app.Application
import com.example.parcial01alexisflores.data.fruitList
import com.example.parcial01alexisflores.repository.FruitRepository

class FruitApplication: Application() {
    val fruitRepository: FruitRepository by lazy {
        FruitRepository(fruitList)
    }
}