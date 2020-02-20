package com.github.myapplication.ProxyMode.MovingProxy

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy
import java.util.*

/**
 * 代理模式（动态）
 * */
class Mall :InvocationHandler{

    var obj: Object? = null

    fun getNewIntent(): Any {
        return Proxy.newProxyInstance(obj?.`class`?.classLoader,
             obj?.`class`?.interfaces,this@Mall)
    }

    override fun invoke(any: Any?, method: Method?, args: Array<out Any>?): Any? {
        println("before http request--->$args")
        yitialong()
//        val invoke = method?.invoke(obj, *(p2))
        //这里是kotlin坑 args参数如果直接放进去会报错 必须写成 *(args ?: arrayOfNulls<Any>(0))
        val ret = method!!.invoke(obj, *(args ?: arrayOfNulls<Any>(0)) )
        wanyi()
        return ret
    }


    fun yitialong(){
        println("一条龙服务")
    }

    fun wanyi(){
        println("满意")
    }

}