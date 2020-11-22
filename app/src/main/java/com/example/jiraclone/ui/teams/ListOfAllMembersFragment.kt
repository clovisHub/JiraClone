package com.example.jiraclone.ui.teams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.jiraclone.R
import com.example.jiraclone.databinding.FragmentAllMembersListBinding
import com.example.jiraclone.ui.BaseFragment

class ListOfAllMembersFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val listOfAllMembersBinding = DataBindingUtil
            .inflate<FragmentAllMembersListBinding>(inflater, R.layout.fragment_all_members_list, container, false)

        return listOfAllMembersBinding.root
    }


    companion object {
        fun newInstance() = ListOfAllMembersFragment()
    }
}