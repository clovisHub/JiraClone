package com.example.jiraclone.repo

import com.example.jiraclone.models.*

object Repository {
    var listOfTask : MutableList<Task> = mutableListOf()
    var teamsList : MutableList<Teams> = mutableListOf()
    //Task(val name: String, val content: String, val assigned: Assigned, val status:Status, val team: String)
    //data class Assigned(val name: String, val contact: String, val mode: Mode)
    init {
            teamsList.add(Teams(0, "Dolphin"))
            teamsList.add(Teams(1, "kayote"))
            teamsList.add(Teams(2, "penguin"))
            teamsList.add(Teams(3, "panda"))
            teamsList.add(Teams(4, "panther"))
            teamsList.add(Teams(5, "wolf"))
            teamsList.add(Teams(6, "gazel"))
            teamsList.add(Teams(7, "ram"))
            teamsList.add(Teams(8, "mouse"))
            teamsList.add(Teams(9, "fox"))
    }

    init {
        listOfTask.add(Task("Create Login", "Login should contains two buttons",Assigned("clovis", "1234", Mode("OffShore")), Status("Not Started"), "First"))
        listOfTask.add(Task("Create Login", "Work on Teams",Assigned("Milton", "1234", Mode("In Office")), Status("Started"), "First"))
        listOfTask.add(Task("Create Login", "Go To honolulu",Assigned("John", "1234", Mode("Vacation")), Status("Not Started"), "second"))
        listOfTask.add(Task("Create Login", "Fly by plane",Assigned("Maurice", "1234", Mode("Travelling")), Status("Not Started"), "First"))
        listOfTask.add(Task("Create Login", "Build a house",Assigned("Allen", "1234", Mode("Construction")), Status("Not Started"), "Third"))
        listOfTask.add(Task("Create Login", "Do shopping",Assigned("Marie", "1234", Mode("Buying")), Status("Not Started"), "First"))
        listOfTask.add(Task("Create Login", "Get A deal on Cars",Assigned("Soso", "1234", Mode("Negotiation")), Status("Not Started"), "First"))
        listOfTask.add(Task("Create Login", "Talk to football players",Assigned("Little Lea", "1234", Mode("Meetings")), Status("Not Started"), "First"))
    }

}