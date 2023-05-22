package com.example.parcial01alexisflores.ui.fruit.fruitstable

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parcial01alexisflores.R
import com.example.parcial01alexisflores.data.model.FruitModel
import com.example.parcial01alexisflores.databinding.FragmentFruitsTableBinding
import com.example.parcial01alexisflores.ui.fruit.fruitstable.recyclerview.FruitRecyclerViewAdapter
import com.example.parcial01alexisflores.ui.fruit.viewmodel.FruitViewModel

class FruitsTableFragment : Fragment() {
    private val fruitViewModel: FruitViewModel by activityViewModels { FruitViewModel.Factory }

    private lateinit var adapter: FruitRecyclerViewAdapter

    private lateinit var binding: FragmentFruitsTableBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFruitsTableBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.floatingActionButton2.setOnClickListener {
            fruitViewModel.clearData()
            it.findNavController().navigate(R.id.action_fruitsTableFragment_to_newFruitFragment)
        }

    }

    private fun setRecyclerView(view: View) {
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = FruitRecyclerViewAdapter { selectedFruit ->
            showSelectedItem(selectedFruit)
        }

        binding.recyclerView.adapter = adapter
        displayFruits()
    }

    private fun displayFruits() {
        adapter.setData(fruitViewModel.getItems())
        adapter.notifyDataSetChanged()
    }

    private fun showSelectedItem(movie: FruitModel) {
        fruitViewModel.setSelectedItem(movie)
        findNavController().navigate(R.id.action_fruitsTableFragment_to_fruitFragment)
    }

}