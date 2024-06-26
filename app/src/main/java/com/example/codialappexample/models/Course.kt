package com.example.codialappexample.models

import java.io.Serializable

class Course : Serializable {

    var id: Int? = null
    var title: String? = null
    var desc: String? = null

    constructor(id: Int?, title: String?, desc: String?) {
        this.id = id
        this.title = title
        this.desc = desc
    }

    constructor(title: String?, desc: String?) {
        this.title = title
        this.desc = desc
    }

    constructor()
}