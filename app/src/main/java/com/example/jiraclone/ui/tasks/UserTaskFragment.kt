package com.example.jiraclone.ui.tasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.jiraclone.R
import com.example.jiraclone.databinding.FragmentListOfTeamsBinding
import com.example.jiraclone.ui.BaseFragment

class UserTaskFragment: BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val listOfTeamBinding = DataBindingUtil
            .inflate<FragmentListOfTeamsBinding>(inflater, R.layout.fragment_list_of_teams, container, false)


        return listOfTeamBinding.root
    }


    companion object {
        fun newInstance() = UserTaskFragment()
    }
}