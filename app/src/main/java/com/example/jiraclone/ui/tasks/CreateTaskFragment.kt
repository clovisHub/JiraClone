package com.example.jiraclone.ui.tasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.example.jiraclone.HomeActivity
import com.example.jiraclone.HomeViewModel
import com.example.jiraclone.R
import com.example.jiraclone.databinding.FragmentTaskCreateBinding
import com.example.jiraclone.models.Assigned
import com.example.jiraclone.models.Task
import com.example.jiraclone.models.TeamMember
import com.example.jiraclone.ui.BaseFragment

class CreateTaskFragment: BaseFragment() {

    private var viewModel: HomeViewModel? = null

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        activity?.let {
            viewModel = if(it is HomeActivity) it.activityViewModel else null
        }

        val createTaskBinding = DataBindingUtil
            .inflate<FragmentTaskCreateBinding>(inflater,
                R.layout.fragment_task_create, container, false)

        createTaskBinding.home = viewModel
        viewModel?.setViewState(1)

        val mutableName = mutableListOf<String>()
        var dataAdapter: ArrayAdapter<String>? = null

        viewModel?.getTeamsList()?.observe(this, {
            it?.let {list ->
                mutableName.clear()
                list.forEach {
                    it.name?.let {nam ->
                        mutableName.add(nam)
                    }
                    dataAdapter = ArrayAdapter(requireContext(),
                        android.R.layout.simple_spinner_item, mutableName
                    )

                    dataAdapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    createTaskBinding.spinnerTeams.adapter = dataAdapter
                }
            }
        })

        createTaskBinding.spinnerTeams
            .onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long) {

                viewModel?.setCurrentTeamMembersList(parent?.getItemAtPosition(position).toString())
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //viewModel?.resetTeamMemberList(parent?.getItemAtPosition(0).toString())
            }
        }

        val mutableTeamName = mutableListOf<String>()
        var dataAdapterTeam: ArrayAdapter<String>? = null
        viewModel?.getTeamMemberList()?.observe(this, { event ->
            event.getContentIfNotHandled<List<TeamMember>>().let {
                it?.let {list ->
                    mutableTeamName.clear()
                    list.forEach {
                        it.lastName?.let {nam ->
                            mutableTeamName.add(nam)
                        }
                        dataAdapterTeam = ArrayAdapter(requireContext(),
                            android.R.layout.simple_spinner_item, mutableTeamName
                        )
                        dataAdapterTeam
                            ?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                        createTaskBinding.spinnerMembers.adapter = dataAdapterTeam
                    }
                }
            }
        })

        createTaskBinding.spinnerMembers
            .onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                viewModel?.setCurrentTeamMemberName(parent?.getItemAtPosition(position).toString())
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        viewModel?.observeCurrentTaskEvent()?.observe(viewLifecycleOwner, {
            it?.let {event ->
                val task = event.getContentIfNotHandled<Task>()

                if(createTaskBinding?.taskCreateContentId?.text.toString().trim().isNotEmpty()
                    && createTaskBinding?.taskCreateDescriptionId?.text.toString().trim().isNotEmpty()) {

                    task?.assigned = Assigned(name = viewModel?.getCurrentTeamMemberName())
                    task?.team = viewModel?.getCurrentTeamName()?:""
                    task?.name = createTaskBinding?.taskCreateTitleNameId?.text.toString()
                    task?.content = createTaskBinding?.taskCreateDescriptionId?.text.toString()

                    task?.let { viewModel?.addTask(task) }
                    Thread.sleep(100L)
                    activity?.supportFragmentManager?.beginTransaction()
                        ?.replace(R.id.frameId, TaskListFragment.newInstance())
                        ?.addToBackStack(null)
                        ?.commit()
                }
            }
        })

        return createTaskBinding.root
    }

    companion object {
        fun newInstance() = CreateTaskFragment()
    }
}