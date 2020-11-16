package com.example.jiraclone.ui.tasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.jiraclone.HomeActivity
import com.example.jiraclone.HomeViewModel
import com.example.jiraclone.R
import com.example.jiraclone.databinding.FragmentTaskCreateBinding
import com.example.jiraclone.models.Status
import com.example.jiraclone.models.Task
import com.example.jiraclone.ui.BaseFragment

class UpdateTaskFragment: BaseFragment() {

    private var viewModel: HomeViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        activity?.let {
            viewModel = if(it is HomeActivity) it.activityViewModel else null
        }

        val createTaskBinding = DataBindingUtil
            .inflate<FragmentTaskCreateBinding>(inflater, R.layout.fragment_task_create, container, false)
        createTaskBinding.taskCreatePageId.text = getString(R.string.update)
        createTaskBinding.taskCreateButtonId.apply {
            text = getString(R.string.update)
            setOnClickListener {
                Thread.sleep(100L)
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.frameId, TaskListFragment.newInstance())
                    ?.addToBackStack(null)
                    ?.commit()
            }
        }

        createTaskBinding.home = viewModel

        viewModel?.observeCurrentTaskEvent()?.observe(viewLifecycleOwner, Observer {
            it?.let {event ->
                val task = event.getContent()
                task?.status
                task?.assigned
                createTaskBinding?.taskCreateTitleNameId?.setText(task.name ?: "")
                createTaskBinding?.taskCreateDescriptionId?.setText(task.content?: "")
                task?.let { viewModel?.addTask(task) }

            }
        })

        return createTaskBinding.root
    }

    companion object {
        fun newInstance() = UpdateTaskFragment()
    }

}