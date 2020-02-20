package com.github.myapplication.bitmapLruCache

import android.app.ActivityManager
import android.content.Context
import android.graphics.Bitmap
import android.util.LruCache

//Kotlin实现
/**
 * LruCacha
 *
 * Bitmap内存优化
 * */
class ImageCacha private constructor() {


    public fun init(context:Context){

        val am:ActivityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        //总内存
        val memoryClass:Int = am.memoryClass

        val lruCache = LruCache<String,Bitmap>(memoryClass / 8 * 1024 * 1024)

    }

    companion object {
        private var instance: ImageCacha? = null
            get() {
                if (field == null) {
                    field = ImageCacha()
                }
                return field
            }

        fun get(): ImageCacha{
            //细心的小伙伴肯定发现了，这里不用getInstance作为为方法名，是因为在伴生对象声明时，内部已有getInstance方法，所以只能取其他名字
            return instance!!
        }
    }


}
