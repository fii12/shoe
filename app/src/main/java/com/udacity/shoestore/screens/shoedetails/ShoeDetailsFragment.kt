package com.udacity.shoestore.screens.shoedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoesViewModel
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding


class ShoeDetailsFragment : Fragment() {
    private val viewModel: ShoesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShoeDetailsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)
        binding.apply {
            shoesViewModel = viewModel
            lifecycleOwner = viewLifecycleOwner
            shoe = viewModel?.newShoe
            fragment = this@ShoeDetailsFragment
        }
        viewModel.eventShoeSaved.observe(viewLifecycleOwner, Observer {
            if (it) {
                navigateBack()
                viewModel.shoeAddedSuccessFully()
            }
        })
        return binding.root
    }


    fun navigateBack() {
        findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
    }

}