package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentCreateShoeBinding

/**
 * A simple [Fragment] subclass.
 * Use the [CreateShoeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateShoeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentCreateShoeBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_create_shoe, container, false
        )

        binding.buttonSave.setOnClickListener { view: View ->
            Navigation.findNavController(view)
                .navigate(R.id.action_createShoeFragment_to_showListFragment)
        }
        binding.buttonCancle.setOnClickListener { view: View ->
            Navigation.findNavController(view)
                .navigate(R.id.action_createShoeFragment_to_showListFragment)
        }
        return binding.root
    }

}