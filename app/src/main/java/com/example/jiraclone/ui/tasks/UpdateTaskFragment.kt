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
        createTaskBinding.taskCreateButtonId.text = "Update"
        createTaskBinding.home = viewModel

        viewModel?.observeCurrentTaskEvent()?.observe(viewLifecycleOwner, Observer {
            it?.let {event ->
                val task = event.getContentIfNotHandled<Task>()

                if(createTaskBinding?.taskCreateContentId?.text.toString().trim().isNotEmpty()
                    && createTaskBinding?.taskCreateDescriptionId?.text.toString().trim().isNotEmpty()) {

                    task?.status = Status("NotStarted")
                    task?.assigned
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
        fun newInstance() = UpdateTaskFragment()
    }

}