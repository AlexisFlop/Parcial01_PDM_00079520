package com.example.parcial01alexisflores.ui.fruit.fruitstable.recyclerview


import androidx.recyclerview.widget.RecyclerView
import com.example.parcial01alexisflores.data.model.FruitModel
import com.example.parcial01alexisflores.databinding.FruitItemBinding

class FruitRecyclerViewHolder (private val binding: FruitItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind (fruit: FruitModel, clickListener: (FruitModel)-> Unit){
            binding.nameFruitTextItem.text = fruit.name
            binding.colorFruitTextItem.text = fruit.color

            binding.fruitItemCardView.setOnClickListener {
                clickListener(fruit)
            }
        }
}