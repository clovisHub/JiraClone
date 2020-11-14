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

class TaskListFragment: BaseFragment(), TaskListAdapter.TaskListListener {

    private var viewModel: HomeViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val taskListBinding = DataBindingUtil
            .inflate<FragmentTasksListBinding>(inflater, R.layout.fragment_tasks_list, container, false)

         activity?.let {
             context?.resources?.getString(R.string.list_of_tasks)?.let {title ->
                 setToolbarText(title)
             }

             viewModel = if(it is HomeActivity) it.activityViewModel else null
         }
        setBackArrowClick()
        setCloseClick()
        taskListBinding.recyclerTaskListId.layoutManager = LinearLayoutManager(context)
        taskListBinding.recyclerTaskListId.adapter = TaskListAdapter(this).apply {

             viewModel?.getListOfTask()?.observe(viewLifecycleOwner, Observer {list ->
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
        viewModel?.setCurrentTask(task)
        Thread.sleep(100L)
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.frameId, TaskDetailsFragment.newInstance())
            ?.addToBackStack(null)
            ?.commit()
    }
}