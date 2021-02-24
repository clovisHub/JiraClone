package com.example.jiraclone.ui.tasks

import android.app.AlertDialog
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jiraclone.HomeViewModel
import com.example.jiraclone.databinding.TaskItemBinding
import com.example.jiraclone.models.Task
import com.example.jiraclone.repo.Repository
import com.example.jiraclone.ui.views.Trashable
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class TaskListAdapter (private val listener: TaskListListener,
                       private var viewModel: HomeViewModel? = null):
    RecyclerView.Adapter<TaskListAdapter.TaskHolder>() , Trashable{

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
        taskHolder.view.apply {
            task = taskList[position]
            visibleCan = true
            trashable = this@TaskListAdapter
            root.setOnClickListener {
                listener.onClick(taskList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    class TaskHolder(val view: TaskItemBinding) : RecyclerView.ViewHolder(view.root)

    interface TaskListListener {
        fun  onClick(task: Task)
    }

    override fun onTrashClick(task: Task) {
        Log.d("Regard", " You made it possible")
        Repository.deleteTask(task)
        viewModel?.refreshListOfTask()
        notifyDataSetChanged()
    }
}