package com.example.motilaloswalassignment.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.motilaloswalassignment.R
import com.example.motilaloswalassignment.databinding.FragmentHomeBinding
import com.example.motilaloswalassignment.util.Constants


class HomeFragment : Fragment() {

    private lateinit var userId: String
    lateinit var fragmentHomeBinding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        userId = arguments?.getString(Constants.USER_ID).toString()
        fragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        fragmentHomeBinding.userId.setText(getString(R.string.hello) + " " + userId)
        return fragmentHomeBinding.root
    }


}
