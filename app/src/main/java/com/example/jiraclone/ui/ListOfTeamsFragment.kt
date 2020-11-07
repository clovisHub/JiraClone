package com.example.jiraclone.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.jiraclone.R
import com.example.jiraclone.databinding.FragmentListOfTeamsBinding

class ListOfTeamsFragment: BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val listOfTeamBinding = DataBindingUtil
            .inflate<FragmentListOfTeamsBinding>(inflater, R.layout.fragment_list_of_teams, container, false)


        return listOfTeamBinding.root
    }


    companion object {
        fun newInstance() = ListOfTeamsFragment()
    }
}