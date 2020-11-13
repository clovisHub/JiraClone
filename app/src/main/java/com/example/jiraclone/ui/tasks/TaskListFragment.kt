package com.example.jiraclone.ui.tasks

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
import com.example.jiraclone.databinding.FragmentTasksListBinding
import com.example.jiraclone.models.Task
import com.example.jiraclone.ui.BaseFragment
import com.example.jiraclone.ui.DashboardFragment
import com.example.jiraclone.ui.UserTaskFragment

class TaskListFragment: BaseFragment(), TaskListAdapter.TaskListListener {

    private var viewModel: HomeViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val taskListBinding = DataBindingUtil
            .inflate<FragmentTasksListBinding>(inflater, R.layout.fragment_tasks_list, container, false)

         activity?.let {
             viewModel = if(it is HomeActivity) it.activityViewModel else null
         }

        taskListBinding.recyclerTaskListId.layoutManager = LinearLayoutManager(context)
        taskListBinding.recyclerTaskListId.adapter = TaskListAdapter(this).apply {

             viewModel?.getListOfTask()?.observe(this@TaskListFragment, Observer {list ->
                 this.setTaskList(list)
             })
         }

        //to create a new task
        taskListBinding.addTaskButtonId.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.frameId, CreateTaskFragment.newInstance())
                ?.addToBackStack(null)
                ?.commit()
        }

        return taskListBinding.root
    }

    companion object {
        fun newInstance() = TaskListFragment()
    }

    override fun onClick(task: Task) {
       //clicked or selected task from the list of Tasks
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.frameId, TaskDetailsFragment.newInstance())
            ?.addToBackStack(null)
            ?.commit()
    }
}