package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentInstructionBinding
import com.udacity.shoestore.databinding.FragmentWellcomBinding

/**
 * A simple [Fragment] subclass.
 * Use the [InstructionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InstructionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentInstructionBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_instruction, container, false
        )
        binding.buttonMoveToShoeList.setOnClickListener {
                view:View-> Navigation.findNavController(view).navigate(R.id.action_instructionFragment_to_showListFragment)
        }
        return binding.root
    }

}