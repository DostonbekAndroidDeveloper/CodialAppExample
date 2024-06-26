package com.example.codialappexample.models

class Student {

    var id: Int? = null
    var name: String? = null
    var surname: String? = null
    var fatherName: String? = null
    var groupId: Group? = null

    constructor(id: Int?, name: String?, surname: String?, fatherName: String?, groupId: Group?) {
        this.id = id
        this.name = name
        this.surname = surname
        this.fatherName = fatherName
        this.groupId = groupId
    }

    constructor(name: String?, surname: String?, fatherName: String?, groupId: Group?) {
        this.name = name
        this.surname = surname
        this.fatherName = fatherName
        this.groupId = groupId
    }

    constructor()
}