package com.github.myapplication.ProxyMode.StaticProxy

/***
 * 一号代理员Karson 准备就绪
 * */
class Karson :Shopping{

    lateinit var faction:Shopping

    constructor(faction: Shopping) {
        this.faction = faction
    }


    override fun gouwu(str: String) {
        baoyou()
        faction.gouwu(str)
        huabei()
    }

    fun baoyou(){
        println("全网包邮")
    }


    fun huabei(){
        println("支持花呗24期")
    }
}