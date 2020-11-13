package com.example.jiraclone.models

data class Task(val name: String, val content: String, val assigned: Assigned, val status:Status, val team: String)

data class Assigned(val name: String, val contact: String, val mode: Mode)

data class Status(val state: String)

data class Mode(val state: String)