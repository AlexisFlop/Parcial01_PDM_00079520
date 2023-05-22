package com.example.parcial01alexisflores.ui.fruit.newfruit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.parcial01alexisflores.databinding.FragmentNewFruitBinding
import com.example.parcial01alexisflores.ui.fruit.viewmodel.FruitViewModel

class NewFruitFragment : Fragment() {

    private val fruitViewModel: FruitViewModel by activityViewModels { FruitViewModel.Factory }
    private lateinit var binding: FragmentNewFruitBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewFruitBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observeStatus()
    }
    private fun setViewModel(){
        binding.viewModel = fruitViewModel
    }
    private fun observeStatus(){
        fruitViewModel.status.observe(viewLifecycleOwner){status ->
            when{
                status.equals(FruitViewModel.WRONG_INFORMATION)-> {fruitViewModel.clearStatus()}
                status.equals(FruitViewModel.MOVIE_CREATED) -> {fruitViewModel.clearStatus()
                    findNavController().popBackStack()}
            }
        }
    }

}