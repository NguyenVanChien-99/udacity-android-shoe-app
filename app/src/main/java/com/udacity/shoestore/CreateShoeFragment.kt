package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
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

    lateinit var viewModel : ShoeListViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentCreateShoeBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_create_shoe, container, false
        )

        viewModel= ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)

        binding.buttonSave.setOnClickListener { view: View ->

            //TODO get from ui
            viewModel.addShoe(Shoe("name",20.0,"com","desc"))
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