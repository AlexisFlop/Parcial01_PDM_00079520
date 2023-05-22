package com.example.parcial01alexisflores.ui.fruit.fruitstable.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial01alexisflores.data.model.FruitModel
import com.example.parcial01alexisflores.databinding.FruitItemBinding

class FruitRecyclerViewAdapter( private val clickListener: (FruitModel) -> Unit
) : RecyclerView.Adapter<MovieRecyclerViewHolder>(){
    private val fruits = ArrayList<FruitModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieRecyclerViewHolder {
        val binding = FruitItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return fruits.size
    }

    override fun onBindViewHolder(holder: MovieRecyclerViewHolder, position: Int) {
        val fruit = fruits[position]
        holder.bind(fruit, clickListener)
    }

    fun setData(moviesList: List<FruitModel>) {
        fruits.clear()
        fruits.addAll(moviesList)
    }

}