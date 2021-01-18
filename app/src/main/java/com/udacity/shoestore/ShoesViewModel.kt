package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoesViewModel : ViewModel() {
    private val _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes

    private val _eventShoeSaved = MutableLiveData<Boolean>()

    val eventShoeSaved: LiveData<Boolean>
        get() = _eventShoeSaved

    var newShoe:Shoe = Shoe("",0.0,"","")

    init {
        _shoes.value = ArrayList()
        _shoes.value?.add(Shoe("Nike Air",43.5,"Nike","Nike Shoes"))
        _shoes.value?.add(Shoe("Nike Air Max",41.5,"Nike","Nike Shoes"))

    }

    fun saveShoe(shoe: Shoe) {
        _shoes.value?.add(shoe)
        _shoes.value = _shoes.value
        _eventShoeSaved.value = true
        newShoe = Shoe("",0.0,"","")
    }

    fun cancel() {
        _eventShoeSaved.value = false
    }

    fun shoeAddedSuccessFully() {
        _eventShoeSaved.value = false
    }

}