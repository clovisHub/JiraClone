package com.example.jiraclone.ui.tasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.jiraclone.R
import com.example.jiraclone.databinding.FragmentTaskDetailsBinding
import com.example.jiraclone.ui.BaseFragment

class TaskDetailsFragment: BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val taskDetailsBinding = DataBindingUtil
            .inflate<FragmentTaskDetailsBinding>(inflater, R.layout.fragment_task_details, container, false)

        return taskDetailsBinding.root
    }


    companion object {
        fun newInstance() = TaskDetailsFragment()
    }
}