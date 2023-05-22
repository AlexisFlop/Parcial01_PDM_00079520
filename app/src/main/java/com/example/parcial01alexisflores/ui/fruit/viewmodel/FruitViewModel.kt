package com.example.parcial01alexisflores.ui.fruit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.parcial01alexisflores.FruitApplication
import com.example.parcial01alexisflores.data.model.FruitModel
import com.example.parcial01alexisflores.repository.FruitRepository

class FruitViewModel(private val fruitRepository: FruitRepository): ViewModel(){
    var name = MutableLiveData("")
    var color = MutableLiveData("")
    var status = MutableLiveData("")

    fun getItems() = fruitRepository.getFruits()

    private fun addFruits(fruit: FruitModel) = fruitRepository.addFruit(fruit)

    fun createFruit() {
        if (!validateData()) {
            status.value = WRONG_INFORMATION
            return
        }

        val fruit = FruitModel(
            name.value!!,
            color.value!!
        )

        addFruits(fruit)
        clearData()

        status.value = MOVIE_CREATED
    }

    private fun validateData(): Boolean {
        when {
            name.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun clearData() {
        name.value = ""
        color.value = ""
    }

    fun clearStatus() {
        status.value = INACTIVE
    }

    fun setSelectedItem(fruit: FruitModel) {
        name.value = fruit.name
        color.value = fruit.color
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as FruitApplication
                FruitViewModel(app.fruitRepository)
            }
        }

        const val MOVIE_CREATED = "Fruit created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }
}