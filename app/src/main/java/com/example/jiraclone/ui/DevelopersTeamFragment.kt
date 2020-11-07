package com.example.jiraclone.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.jiraclone.R
import com.example.jiraclone.databinding.FragmentDevelopersListBinding

class DevelopersTeamFragment: BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val developersBinding = DataBindingUtil
            .inflate<FragmentDevelopersListBinding>(inflater, R.layout.fragment_developers_list, container, false)

        return developersBinding.root
    }

    companion object {
        fun newInstance() = DashboardFragment()
    }
}