package com.github.myapplication.ProxyMode.StaticProxy

class Mark :Eat{

    lateinit var eat:Eat

    constructor(eat: Eat) {
        this.eat = eat
    }


    override fun apple(size: Int) {
        goumai()
        eat.apple(size)
        succeed()
    }

    fun goumai(){
        println("购买材料")
    }

    fun succeed(){
        println("完成 ")
    }
}