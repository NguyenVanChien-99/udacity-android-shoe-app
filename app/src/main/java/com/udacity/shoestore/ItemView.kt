package com.udacity.shoestore

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

class ItemView: LinearLayout {

    private var textName: TextView? = null
    private var textCompany: TextView? = null
    private var textSize: TextView? = null
    private var textDesc: TextView? = null


    constructor(context: Context?) : super(context!!) {
        initialize()
    }

    private fun initialize() {
        LayoutInflater.from(context)
            .inflate(R.layout.item, this)
        textName = findViewById(R.id.textName)
        textCompany = findViewById(R.id.textCompany)
        textSize = findViewById(R.id.textSize)
        textDesc = findViewById(R.id.textDesc)
    }

    fun setItem(name:String, company :String, size :Double, desc:String) {
        textName?.text = name
        textCompany?.text = company
        textSize?.text = size.toString()
        textDesc?.text = desc
    }
}