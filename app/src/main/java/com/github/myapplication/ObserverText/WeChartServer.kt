package com.github.myapplication.ObserverText

import java.util.*


/**
 * 具体的被观察者类
 * 微信公众号服务
 *
 * */
class WeChartServer :Observable{

    var message:String = ""

    constructor()

    /**
     * 添加一个观察者
     * */
    override fun add(observer: Observer) {
        list.add(observer)
    }

    /**
     * 删除一个观察者
     * */
    override fun remove(observer: Observer) {
        list.remove(observer)
    }

    public fun pushMessage(string: String){
        this.message = string
        System.out.println("微信")
        notifyObservers()
    }

    /**
     * 通知所有的观察者
     * */
    override fun notifyObservers() {
        list.forEach { item ->
            item.Updata(message)
        }
    }

    companion object{
        var list = mutableListOf<Observer>()
    }

}