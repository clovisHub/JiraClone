package com.example.jiraclone.ui.teams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.jiraclone.R
import com.example.jiraclone.databinding.FragmentNewTeamCreateBinding
import com.example.jiraclone.ui.BaseFragment

class CreateNewTeamFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val createNewTeamBinding = DataBindingUtil
            .inflate<FragmentNewTeamCreateBinding>(inflater, R.layout.fragment_new_team_create, container, false)

        return createNewTeamBinding.root
    }


    companion object {
        fun newInstance() = CreateNewTeamFragment()
    }
}