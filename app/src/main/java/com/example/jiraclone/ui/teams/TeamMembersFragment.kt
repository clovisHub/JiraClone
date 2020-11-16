package com.example.jiraclone.ui.teams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jiraclone.HomeActivity
import com.example.jiraclone.HomeViewModel
import com.example.jiraclone.R
import com.example.jiraclone.databinding.FragmentDevListBinding
import com.example.jiraclone.databinding.FragmentTeamMembersBinding
import com.example.jiraclone.ui.BaseFragment
import com.example.jiraclone.ui.DashboardFragment

class TeamMembersFragment: BaseFragment() {

    private var viewModel : HomeViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val teamMembersBinding = DataBindingUtil
            .inflate<FragmentTeamMembersBinding>(inflater, R.layout.fragment_team_members, container, false)

        activity?.let{
            context?.resources?.getString(R.string.list_of_Teams)?.let { title->
                setToolbarText(title)
            }
            viewModel = if(it is HomeActivity) it. activityViewModel else null
        }

        viewModel?.observeCurrentTeamEvent()?.observe(viewLifecycleOwner, Observer {
            it?.let { event ->
                event.getContent()?.let{teams ->
                    teamMembersBinding.recyclerDevListId.layoutManager = LinearLayoutManager(context)
                }
            }
        })
        return teamMembersBinding.root
    }

    companion object {
        fun newInstance() = TeamMembersFragment()
    }
}