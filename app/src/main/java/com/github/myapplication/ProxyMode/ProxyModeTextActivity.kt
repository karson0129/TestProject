package com.github.myapplication.ProxyMode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.myapplication.ProxyMode.MovingProxy.Mall
import com.github.myapplication.ProxyMode.StaticProxy.*
import com.github.myapplication.R


/**
 *  @author 叶俊晖
 *  代码模式 学习
 * */
class ProxyModeTextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proxy_mode_text)

        staticProxy()

        println("=======================分割线==============================")

        movingProxy()
    }


    /**
     * 静态代理模式
     * */
    private fun staticProxy(){
        var shopping:Shopping = AFactory()
        var karson:Karson = Karson(shopping)
        karson.gouwu("香蕉")

        var eat:Eat = BFactory()
        var mark:Mark = Mark(eat)
        mark.apple(18)
    }

    /**
     * 动态代理
     * */
    private fun movingProxy(){
        val shopping:Shopping = AFactory()
        val mall:Mall = Mall()
        mall.obj = shopping as Object
        val newIntent:Shopping = mall.getNewIntent() as Shopping
        newIntent.gouwu("动态购物啦")

        println("=======================分割线==============================")

        val eat:Eat = BFactory()
        mall.obj = eat as Object
        val newIntent1 = mall.getNewIntent() as Eat
        newIntent1.apple(20)
    }

}
