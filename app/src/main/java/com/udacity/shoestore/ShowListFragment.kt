package com.udacity.shoestore

import android.content.ClipData.Item
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShowListBinding


/**
 * A simple [Fragment] subclass.
 * Use the [ShowListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShowListFragment : Fragment() {


    lateinit var viewModel : ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentShowListBinding= DataBindingUtil.inflate(
            inflater,R.layout.fragment_show_list,container,false
        )

        viewModel= ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)
        viewModel.shoes.observe(viewLifecycleOwner, Observer { shoeList->
            if(!shoeList.isNullOrEmpty()){
                shoeList.forEach{item->
                    val itemView = ItemView(context)
                    itemView.setItem(item.name,item.company,item.size,item.description)
                    itemView.layoutParams=LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
                    val listLayout: LinearLayout= binding.viewShoeList
                    listLayout.addView(itemView)
                }
            }
        })

        binding.goToDetailBtn.setOnClickListener { view:View->
            Navigation.findNavController(view).navigate(R.id.action_showListFragment_to_createShoeFragment)
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

}