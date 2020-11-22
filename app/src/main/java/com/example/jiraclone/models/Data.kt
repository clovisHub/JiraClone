package com.example.jiraclone.models


data class ListOfTeam(var teamList: List<Team>? = null)

data class Team( var logo: String? = "", var name : String? = "", var listOfMembers: List<TeamMember>? = null)

data class TeamMember (var firstName:  String? = "",
                       var lastName : String? = "",
                       var teamName: String? ="",
                       var teamLead : Boolean? = false,
                       var listOfTask: List<Task>? = null)

data class Task(var name: String?="",
                var content: String? ="",
                var assigned: Assigned?= null,
                var status:Status? = null,
                var team: String ? = "")

data class Assigned(val name: String? = "", val contact: String? ="", val mode: Mode)

data class Status(val state: String? = "")

data class Mode(val state: String? = "")