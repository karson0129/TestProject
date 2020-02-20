package com.github.myapplication.ObserverText


/**
 * 抽象得被观察类
 * */
interface Observable {

    fun add(observer: Observer)

    fun remove(observer: Observer)

    fun notifyObservers()
}