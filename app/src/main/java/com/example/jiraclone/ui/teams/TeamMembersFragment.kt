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
import com.example.jiraclone.databinding.FragmentTeamMembersBinding
import com.example.jiraclone.models.TeamMember
import com.example.jiraclone.ui.BaseFragment

class TeamMembersFragment: BaseFragment(), TeamMembersAdapter.TeamMemberListener {

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
        setBackArrowClick()
        setCloseClick()
        teamMembersBinding.recyclerTeamMembersListId.layoutManager = LinearLayoutManager(context)
        teamMembersBinding.recyclerTeamMembersListId.adapter = TeamMembersAdapter(this).apply {
            viewModel?.getTeamMemberList()?.observe(this@TeamMembersFragment, Observer { list ->
                this.setTeamMemberList(list)
            })
        }
        teamMembersBinding.addDevId.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.frameId,AddNewMemberFragment.newInstance())
                ?.addToBackStack(null)
                ?.commit()
        }
        return teamMembersBinding.root
    }

    companion object {
        fun newInstance() = TeamMembersFragment()
    }

    override fun onClick(teamMember: TeamMember) {

        viewModel?.setCurrentTeamMember(teamMember)
        Thread.sleep(100L)
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.frameId, WorkBasketFragment.newInstance())
            ?.addToBackStack(null)
            ?.commit()
    }
}