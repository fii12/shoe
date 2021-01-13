package com.udacity.shoestore.screens.shoedetails

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoesViewModel
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.Shoe


class ShoeDetailsFragment : Fragment() {
    private val shoesViewModel: ShoesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentShoeDetailsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)

        binding.lifecycleOwner = this
        binding.shoesViewModel = shoesViewModel
        binding.shoe = Shoe("", 0.0, "", "")


        shoesViewModel.eventShoeSaved.observe(viewLifecycleOwner, Observer { it ->
            Log.e("ShoeDetails", "observe! it: "+it)
//            if(it){
//                shoesViewModel.eventShoeSaved.value = false
            Toast.makeText(activity, "Saved!", Toast.LENGTH_SHORT).show()
            navigateBack()
//            }
            Log.e("ShoeDetails", "endd observe!")

        })


//        binding.saveButton.setOnClickListener {
//            navigateBack()
//        }

        return binding.root
    }

    private fun navigateBack() {
        findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
    }


}