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
import com.example.jiraclone.databinding.FragmentListOfTeamsBinding
import com.example.jiraclone.models.Team
import com.example.jiraclone.ui.BaseFragment

class ListOfTeamsFragment: BaseFragment(), TeamListAdapter.TeamsListListener {

    private var viewModel: HomeViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val listOfTeamBinding = DataBindingUtil
            .inflate<FragmentListOfTeamsBinding>(inflater, R.layout.fragment_list_of_teams, container, false)

            activity?.let {
                context?.resources?.getString(R.string.list_of_Teams)?.let {title ->
                    setToolbarText(title)
                }
                viewModel = if(it is HomeActivity) it.activityViewModel else null
            }
        setBackArrowClick()
        setCloseClick()
        listOfTeamBinding.recyclerTeamsId.layoutManager = LinearLayoutManager(context)
        listOfTeamBinding.recyclerTeamsId.adapter = TeamListAdapter(this)
            .apply {
                viewModel?.getTeamsList()?.observe(this@ListOfTeamsFragment, Observer { list ->
                    this.setTeamList(list)
                })
        }

        listOfTeamBinding.addTeamBtn.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.frameId,CreateNewTeamFragment.newInstance())
                ?.addToBackStack(null)
                ?.commit()
        }

        return listOfTeamBinding.root
    }

    companion object {
        fun newInstance() = ListOfTeamsFragment()
    }

    override fun onClick(teams: Team) {
        //clicked or selected team from the list of Teams
        viewModel?.setCurrenntTeam(teams)
        Thread.sleep(100L)
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.frameId, TeamMembersFragment.newInstance())
            ?.addToBackStack(null)
            ?.commit()
    }
}