package com.example.jiraclone

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jiraclone.models.Task
import com.example.jiraclone.repo.Repository

class HomeViewModel: ViewModel() {

    private val liveTaskList: MutableLiveData<List<Task>> = MutableLiveData()
    private val liveTaskEvent : MutableLiveData<Event<Task>> = MutableLiveData()

    init {
        liveTaskList.value = Repository.listOfTask
        Log.d("numbers", Repository.listOfTask.size.toString())
    }

    fun getListOfTask() : LiveData<List<Task>> = liveTaskList

    fun createTask() {
       liveTaskEvent.value = Event(Task())
    }

    fun observeCurrentTaskEvent() : LiveData<Event<Task>> = liveTaskEvent

    fun addTask(task: Task) {
        Repository.listOfTask.add(task)
        Log.d("numbers", Repository.listOfTask.size.toString())
    }

}