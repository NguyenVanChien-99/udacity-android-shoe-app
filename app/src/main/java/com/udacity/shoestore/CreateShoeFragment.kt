package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentCreateShoeBinding
import com.udacity.shoestore.models.Shoe

/**
 * A simple [Fragment] subclass.
 * Use the [CreateShoeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateShoeFragment : Fragment() {

    val viewModel: ShoeListViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentCreateShoeBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_create_shoe, container, false
        )

//        viewModel= ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)

        binding.viewModel= viewModel
        binding.lifecycleOwner=this

        binding.buttonSave.setOnClickListener { view: View ->
            addShoe(binding,view)
        }
        binding.buttonCancle.setOnClickListener { view: View ->
            Navigation.findNavController(view)
                .navigate(R.id.action_createShoeFragment_to_showListFragment)
        }
        return binding.root
    }

    fun addShoe(binding: FragmentCreateShoeBinding,view: View){

        viewModel.addShoe()
        Navigation.findNavController(view)
            .navigate(R.id.action_createShoeFragment_to_showListFragment)
    }

}