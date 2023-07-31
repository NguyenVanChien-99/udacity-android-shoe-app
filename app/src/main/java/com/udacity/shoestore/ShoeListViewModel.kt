package com.udacity.shoestore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    val shoes = MutableLiveData<List<Shoe>>();

    fun addShoe(shoe: Shoe){
        shoes.value= shoes.value?.plus(shoe) ?: listOf(shoe);
    }
}