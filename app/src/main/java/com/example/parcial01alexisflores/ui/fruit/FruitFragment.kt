package com.example.parcial01alexisflores.ui.fruit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.parcial01alexisflores.R
import com.example.parcial01alexisflores.databinding.ActivityMainBinding
import com.example.parcial01alexisflores.databinding.FragmentFruitBinding
import com.example.parcial01alexisflores.ui.fruit.viewmodel.FruitViewModel

class FruitFragment : Fragment() {
    private lateinit var binding: FragmentFruitBinding
    private val fruitViewModel: FruitViewModel by activityViewModels { FruitViewModel.Factory }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFruitBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
    }

    private fun setViewModel(){
        binding.viewModel = fruitViewModel
    }
}