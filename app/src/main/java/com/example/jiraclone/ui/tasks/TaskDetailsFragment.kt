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
import com.example.jiraclone.databinding.FragmentTaskDetailsBinding
import com.example.jiraclone.models.Task
import com.example.jiraclone.ui.BaseFragment

class TaskDetailsFragment: BaseFragment() {

    private var viewModel: HomeViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val taskDetailsBinding = DataBindingUtil
            .inflate<FragmentTaskDetailsBinding>(inflater, R.layout.fragment_task_details, container, false)

        activity?.let {
            context?.resources?.getString(R.string.task_details)?.let {title ->
                setToolbarText(title)
            }
            viewModel = if(it is HomeActivity) it.activityViewModel else null
        }

        viewModel?.observeCurrentTaskEvent()?.observe(viewLifecycleOwner, Observer {
            it?.let {event ->
                 event.getContent()?.let {task ->
                     taskDetailsBinding.taskDetailsTitleId.text = task.name
                     taskDetailsBinding.taskDetailsAssignedId.text = task.assigned?.name?: ""
                     taskDetailsBinding.taskDetailsDescriptionId.text = task.content
                     taskDetailsBinding.taskDetailsStatusId.text = task.status?.name ?: ""
                 }
            }
        })

        taskDetailsBinding.taskDetailsCloseId.setOnClickListener {
            viewModel?.observeCurrentTaskEvent()?.value?.let {event ->
                viewModel?.setCurrentTask(event.getContent())
            }
            Thread.sleep(100L)
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.frameId, UpdateTaskFragment.newInstance())
                ?.addToBackStack(null)
                ?.commit()
        }

        return taskDetailsBinding.root
    }


    companion object {
        fun newInstance() = TaskDetailsFragment()
    }
}