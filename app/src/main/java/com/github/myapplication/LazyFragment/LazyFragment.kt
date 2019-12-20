package com.github.myapplication.LazyFragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import kotlin.math.E
import kotlin.math.log

/**
 * 懒加载
 * @author 叶俊晖
 * @Data 2019/12/20
 * */
abstract class LazyFragment :Fragment(){

    //容器View
    private lateinit var viewRoot:View
    //是否初始化了
    private var isViewCreated:Boolean = false
    //保存Loading状态 如果已经Loading 过了 就不在Loading
    private var isCurrentVisibleState:Boolean = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       if (viewRoot == null){
           viewRoot = inflater.inflate(getLayoutRes(),container,false)
       }
        initView(viewRoot)
        //这里表示ViewRoot已经创创建完成
        isViewCreated = true
        //如果 第一次获取的时候 是true 那么 表示这个页面已经是 用户 可见 这里 手动分发事件
        //如果不分发会造成 第一次一直在Loading 不会去 加载网络
        if(userVisibleHint){
            userVisibleHint = true
        }
        return viewRoot
    }

    //获取实际加载的View
    abstract fun getLayoutRes():Int
    //初始化
    abstract fun initView(view: View)

    override fun onResume() {
        super.onResume()
        if (userVisibleHint){ //用于离开了这个页面以后，回来 重新加载网络
            dispatchUserVisibleHint(true)
        }
    }

    //控制 是否可见
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isViewCreated){
            if (isVisibleToUser && !isCurrentVisibleState){
                dispatchUserVisibleHint(true)
            }else if (isCurrentVisibleState && !isVisibleToUser){
                dispatchUserVisibleHint(false)
            }
        }
    }

    fun dispatchUserVisibleHint(isVisibleToUser: Boolean){
        if (isCurrentVisibleState == isVisibleToUser){
            return
        }
        isCurrentVisibleState = isVisibleToUser
        if (isVisibleToUser){
            onFragmentLoad()
        }else{
            onFragmentLoadStop()
        }
    }

    /** =======================================
     *            触发停止加载网络
     *========================================= */
    public fun onFragmentLoadStop(){

    }

    /** =======================================
     *               触发加载网络
     *========================================= */
    public fun onFragmentLoad(){

    }

    override fun onPause() {
        super.onPause()
        if (userVisibleHint){ //如果当前页面可见 那么需要在离开这个页面的时候 停止加载网络
            dispatchUserVisibleHint(false)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        isViewCreated = false
    }

    //构造函数
    companion object{
       private var Tag = "LazyFragment"

    }

}