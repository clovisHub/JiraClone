package com.example.jiraclone.ui.teams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.jiraclone.R
import com.example.jiraclone.databinding.FragmentDevListBinding
import com.example.jiraclone.ui.BaseFragment
import com.example.jiraclone.ui.DashboardFragment

class DevelopersTeamFragment: BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val developersBinding = DataBindingUtil
            .inflate<FragmentDevListBinding>(inflater, R.layout.fragment_dev_list, container, false)

        return developersBinding.root
    }

    companion object {
        fun newInstance() = DashboardFragment()
    }
}