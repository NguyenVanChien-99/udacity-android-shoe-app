package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentWellcomBinding

/**
 * A simple [Fragment] subclass.
 * Use the [WellcomFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WellcomFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentWellcomBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_wellcom, container, false
        )

        val agrs = WellcomFragmentArgs.fromBundle(requireArguments())
        binding.textUserEmail.setText(agrs.username)

        binding.buttonInstruction.setOnClickListener {
                view:View-> Navigation.findNavController(view).navigate(R.id.action_wellcomFragment_to_instructionFragment)
        }
        return binding.root
    }

}