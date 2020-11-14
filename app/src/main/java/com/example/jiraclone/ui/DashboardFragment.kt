package com.example.jiraclone.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.jiraclone.R
import com.example.jiraclone.databinding.FragmentDashboardBinding
import com.example.jiraclone.ui.tasks.TaskListFragment


class DashboardFragment: BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         val dashboardBinding = DataBindingUtil
             .inflate<FragmentDashboardBinding>(inflater, R.layout.fragment_dashboard, container, false)

        setToolbarText("Dashboard", false)
        dashboardBinding.teamId.setOnClickListener {
             activity?.supportFragmentManager?.beginTransaction()
                 ?.replace(R.id.frameId, ListOfTeamsFragment.newInstance())
                 ?.addToBackStack(null)
                 ?.commit()
        }

        dashboardBinding.taskId.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.frameId, TaskListFragment.newInstance())
                ?.addToBackStack(null)
                ?.commit()
        }

        dashboardBinding.extraId.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.frameId, ListOfTeamsFragment.newInstance())
                ?.addToBackStack(null)
                ?.commit()
        }

        return dashboardBinding.root
    }

    companion object {
        fun newInstance() = DashboardFragment()
    }
}