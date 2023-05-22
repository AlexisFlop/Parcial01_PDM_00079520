package com.example.parcial01alexisflores.repository

import com.example.parcial01alexisflores.data.fruitList
import com.example.parcial01alexisflores.data.model.FruitModel

class FruitRepository(private val fruits: MutableList<FruitModel>) {
    fun getFruits() = fruits

    fun addFruit(fruit: FruitModel) = fruitList.add(fruit)
}