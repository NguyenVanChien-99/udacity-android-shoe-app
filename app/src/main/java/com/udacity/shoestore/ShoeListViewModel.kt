package com.udacity.shoestore

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    val shoes = MutableLiveData<List<Shoe>>();

    var shoeName:MutableLiveData<String> = MutableLiveData()
    var companyName:MutableLiveData<String> = MutableLiveData()
    var size:MutableLiveData<String> = MutableLiveData()
    var desc:MutableLiveData<String> = MutableLiveData()
    fun addShoe(){

        var sizeDouble:Double=0.0
        if( size.value.toString().isNotEmpty()){
            sizeDouble=size.value.toString().toDouble()
        }
        var shoe= Shoe(shoeName.value.toString(),sizeDouble,companyName.value.toString(),desc.value.toString())
        shoes.value= shoes.value?.plus(shoe) ?: listOf(shoe);
    }
}