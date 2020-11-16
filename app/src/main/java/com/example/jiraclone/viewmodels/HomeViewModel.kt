package com.example.jiraclone

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jiraclone.models.Task
import com.example.jiraclone.models.Teams
import com.example.jiraclone.repo.Repository

class HomeViewModel: ViewModel() {

    private val liveTaskList: MutableLiveData<List<Task>> = MutableLiveData()
    private val liveTeamsList: MutableLiveData<List<Teams>> = MutableLiveData()
    private val liveTaskEvent : MutableLiveData<Event<Task>> = MutableLiveData()
    private val liveTeamEvent : MutableLiveData<Event<Teams>> = MutableLiveData()

    init {
        liveTaskList.value = Repository.listOfTask
        Log.d("numbers", Repository.listOfTask.size.toString())
        liveTeamsList.value = Repository.teamsList
    }

    fun getListOfTask() : LiveData<List<Task>> = liveTaskList
    fun getTeamsList() : LiveData<List<Teams>> = liveTeamsList

    fun setCurrentTask(task: Task) {
        liveTaskEvent.value = Event(task)
    }

    fun setCurrenntTeam(teams: Teams){
        liveTeamEvent.value = Event(teams)
    }

    fun createTask() {
        liveTaskEvent.value = Event(Task())
    }

    fun createTeam(){
        liveTeamEvent.value = Event(Teams(0, ""))
    }

    fun observeCurrentTaskEvent() : LiveData<Event<Task>> = liveTaskEvent
    fun observeCurrentTeamEvent() : LiveData<Event<Teams>> = liveTeamEvent

    fun addTask(task: Task) {
        Repository.listOfTask.add(task)
        Log.d("numbers", Repository.listOfTask.size.toString())
    }

    fun addNewTeam(teams: Teams) {
        Repository.teamsList.add(teams)
        Log.d("numbers", Repository.teamsList.size.toString())
    }
}