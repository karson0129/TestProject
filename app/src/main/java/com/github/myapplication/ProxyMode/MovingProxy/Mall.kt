package com.github.myapplication.ProxyMode.MovingProxy

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy
import java.util.*

class Mall :InvocationHandler{

    var obj:Object? = null

    fun getNewIntent(): Any {
        return Proxy.newProxyInstance(obj?.`class`?.classLoader,
             obj?.`class`?.interfaces,this@Mall)
    }

    override fun invoke(any: Any?, method: Method?, p2: Array<out Any>?): Any {
        yitialong()
        val invoke = method?.invoke(obj, p2)
        wanyi()
        return invoke!!
    }

    fun yitialong(){
        println("一条龙服务")
    }

    fun wanyi(){
        println("满意")
    }

}