package com.example.jiraclone.ui.tasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.jiraclone.R
import com.example.jiraclone.databinding.FragmentTaskCreateBinding
import com.example.jiraclone.ui.BaseFragment

class CreateTaskFragment: BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val createTaskBinding = DataBindingUtil
            .inflate<FragmentTaskCreateBinding>(inflater, R.layout.fragment_task_create, container, false)

        return createTaskBinding.root
    }


    companion object {
        fun newInstance() = CreateTaskFragment()
    }

}