package com.example.jiraclone.ui.tasks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jiraclone.databinding.TaskItemBinding
import com.example.jiraclone.models.Task

class TaskListAdapter (private val listener: TaskListListener): RecyclerView.Adapter<TaskListAdapter.TaskHolder>() {

    private var taskList: MutableList<Task> = mutableListOf()

    fun setTaskList(tasks: List<Task>) {
        taskList.clear()
        taskList.addAll(tasks)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): TaskHolder {
        val view  = TaskItemBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)

        return TaskHolder(view)
    }

    override fun onBindViewHolder(taskHolder: TaskHolder, position: Int) {
           taskHolder.view.task = taskList[position]
           taskHolder.view.root.setOnClickListener {
               listener.onClick(taskList[position])
           }
    }

    override fun getItemCount(): Int {
        return taskList.size
    }


    class TaskHolder(val view: TaskItemBinding) : RecyclerView.ViewHolder(view.root)

    interface TaskListListener {
        fun  onClick(task: Task)
    }

}