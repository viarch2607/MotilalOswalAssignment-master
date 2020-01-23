package com.example.motilaloswalassignment.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.motilaloswalassignment.R
import com.example.motilaloswalassignment.databinding.FragmentLoginBinding
import com.example.motilaloswalassignment.util.Constants
import com.example.motilaloswalassignment.util.Toaster
import com.example.motilaloswalassignment.viewmodels.LoginViewModel
import org.koin.android.viewmodel.ext.android.viewModel



class LoginFragment : Fragment() {
    val viewModel: LoginViewModel by viewModel()
    lateinit var fragmentLoginBinding: FragmentLoginBinding
    lateinit var navController: NavController
    private lateinit var bundle: Bundle


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentLoginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)


        fragmentLoginBinding.btnlogin.setOnClickListener(View.OnClickListener {
           validateFields();
        })
        return fragmentLoginBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

     fun validateFields() {
        try {
            var userId = fragmentLoginBinding.editTextUserId.text.toString()
            var password = fragmentLoginBinding.editTextPassword.text.toString()

            if (viewModel.isValidUseridandPassword(userId, password)) {

                viewModel.validateInputs(userId,password).observe(this, Observer {
                        if(it.equals(Constants.ACTION_SUCCESS_MSG)){
                            bundle = bundleOf(Constants.USER_ID to userId)
                            navController.navigate(R.id.action_loginFragment_to_homeFragment, bundle)
                        }else{
                            Toaster.show(requireContext(),
                                getString(R.string.invalid_input))
                        }

                    })



            } else {
                Toaster.show(requireContext(),
                    getString(R.string.fill_all_fields))
            }

        } catch (e: Exception) {
            e.message
        }
    }

}
