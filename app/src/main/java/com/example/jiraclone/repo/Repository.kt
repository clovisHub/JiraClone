package com.example.jiraclone.repo

import com.example.jiraclone.models.Assigned
import com.example.jiraclone.models.Mode
import com.example.jiraclone.models.Status
import com.example.jiraclone.models.Task

object Repository {
    var listOfTask : MutableList<Task> = mutableListOf()
    //Task(val name: String, val content: String, val assigned: Assigned, val status:Status, val team: String)
    //data class Assigned(val name: String, val contact: String, val mode: Mode)
    init {
        listOfTask.add(Task("Create Login", "Login should contains two buttons",Assigned("clovis", "1234", Mode("OffShore")), Status("Not Started"), "First"))
        listOfTask.add(Task("Create Work", "Work on Teams",Assigned("Milton", "1234", Mode("In Office")), Status("Started"), "First"))
        listOfTask.add(Task("Visit Honolulu", "Go To honolulu",Assigned("John", "1234", Mode("Vacation")), Status("Not Started"), "second"))
        listOfTask.add(Task("Fly Abroad", "Fly by plane",Assigned("Maurice", "1234", Mode("Travelling")), Status("Not Started"), "First"))
        listOfTask.add(Task("Build", "Build a house",Assigned("Allen", "1234", Mode("Construction")), Status("Not Started"), "Third"))
        listOfTask.add(Task("Amazon", "Do shopping",Assigned("Marie", "1234", Mode("Buying")), Status("Not Started"), "First"))
        listOfTask.add(Task("Car dealers", "Get A deal on Cars",Assigned("Soso", "1234", Mode("Negotiation")), Status("Not Started"), "First"))
        listOfTask.add(Task("Coach Team", "Talk to football players",Assigned("Little Lea", "1234", Mode("Meetings")), Status("Not Started"), "First"))
    }

}