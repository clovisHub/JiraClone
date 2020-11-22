package com.example.jiraclone.repo

import com.example.jiraclone.models.*

object Repository {
    var listOfTask : MutableList<Task> = mutableListOf()
    var teamsList : MutableList<Team> = mutableListOf()
    var teamMemberList : MutableList<TeamMember> = mutableListOf()
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

        teamsList.add(Team("0", "Dolphin"))
        teamsList.add(Team("1", "kayote"))
        teamsList.add(Team("2", "penguin"))
        teamsList.add(Team("3", "panda"))
        teamsList.add(Team("4", "panther"))
        teamsList.add(Team("5", "wolf"))
        teamsList.add(Team("6", "gazel"))
        teamsList.add(Team("7", "ram"))
        teamsList.add(Team("8", "mouse"))
        teamsList.add(Team("9", "fox"))

        teamMemberList.add(TeamMember("Liam","Ethan",true))
        teamMemberList.add(TeamMember("Soso","Milton",true))
        teamMemberList.add(TeamMember("Clova","Inak",false))
        teamMemberList.add(TeamMember("Marie","Inaka",true))
        teamMemberList.add(TeamMember("Mira","Abonge",true))
        teamMemberList.add(TeamMember("Milton","Ak",true))
    }

}