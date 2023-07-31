package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentLoginBinding
import java.util.logging.Level
import java.util.logging.Logger


/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )

        binding.buttonLogin.setOnClickListener {
            view:View-> moveToNextPage(binding.textEmail.text.toString(),binding.textPassword.text.toString(),view)
        }
        binding.buttonCreateAccount.setOnClickListener {
                view:View-> moveToNextPage(binding.textEmail.text.toString(),binding.textPassword.text.toString(),view)
        }

        return binding.root
    }


    fun moveToNextPage(email: String, password: String, view: View) {
        if (email.isEmpty()|| password.isEmpty()) {
            Toast.makeText(context, "Invalid email or password", Toast.LENGTH_LONG).show()
            return
        }
        Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_wellcomFragment)
    }
}