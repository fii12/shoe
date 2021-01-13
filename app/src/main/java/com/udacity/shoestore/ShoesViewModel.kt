package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoesViewModel : ViewModel() {
    private val _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoes: MutableLiveData<MutableList<Shoe>>
        get() = _shoes

    private val _eventShoeSaved = MutableLiveData<Boolean>()
    val eventShoeSaved: MutableLiveData<Boolean>
        get() = _eventShoeSaved


    init {
        Log.e("TAG", "init!!!!!!!!!!!")
        _shoes.value = ArrayList()
    }

    fun saveShoe(shoe: Shoe) {
        _shoes.value?.add(shoe)
        _shoes.value = _shoes.value
        _eventShoeSaved.value = true
    }


}