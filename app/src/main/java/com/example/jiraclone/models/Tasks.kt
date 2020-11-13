package com.example.jiraclone.models

data class Task(var name: String ="", var content: String ="", var assigned: Assigned?= null, var status:Status? = null, var team: String ? = null)

data class Assigned(val name: String, val contact: String, val mode: Mode)

data class Status(val state: String)

data class Mode(val state: String)