package com.example.jiraclone.ui.teams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.jiraclone.HomeActivity
import com.example.jiraclone.R
import com.example.jiraclone.databinding.FragmentListOfTeamsBinding
import com.example.jiraclone.models.Task
import com.example.jiraclone.models.Teams
import com.example.jiraclone.ui.BaseFragment
import com.example.jiraclone.ui.tasks.TaskDetailsFragment
import com.example.jiraclone.viewmodels.HomeViewModel

class ListOfTeamsFragment: BaseFragment(), TeamListAdapter.TeamsListListener {

    private var viewModel: HomeViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val listOfTeamBinding = DataBindingUtil
            .inflate<FragmentListOfTeamsBinding>(inflater, R.layout.fragment_list_of_teams, container, false)

            activity?.let {
                viewModel = if(it is HomeActivity) it.activityViewModel else null
            }
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

    override fun onClick(teams: Teams) {
        //clicked or selected team from the list of Teams
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.frameId, ListOfDevsFragment.newInstance())
            ?.addToBackStack(null)
            ?.commit()
    }
}