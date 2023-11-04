package com.turacican.kotlinoop

class SuperHero {

    var _name = ""
    var _age = -1
    var _job = ""

    constructor(name: String, age: Int, job: String ){
        this._name = name
        this._age = age
        this._job = job
    }

    fun Getir() : String{
        return "Adınız: ${this._name}, Yaşınız: ${this._age}, Mesleğiniz: ${this._job}"
    }
}