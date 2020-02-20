package com.github.myapplication.shuiyin

import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.github.myapplication.R
import kotlinx.android.synthetic.main.activity_shui_yin.*


class ShuiYinActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shui_yin)

        init()
    }


    private fun init(){

        //获取原始图片
        val sourBitmap = (picture.getDrawable() as BitmapDrawable).bitmap
        //水印图片
        val waterBitmap = BitmapFactory.decodeResource(resources, R.mipmap.waixingren)

        val textview:TextView = TextView(this@ShuiYinActivity)

        textview.text = "我是一个水印"
        textview.textSize = 22f
        //添加水印到中间
        var watermarkBitmap =
            ImageUtil.createWaterMaskCenter(
                sourBitmap,
                waterBitmap
            )
        //添加文字水印
        watermarkBitmap = ImageUtil.createWaterMaskLeftBottom(
            watermarkBitmap,
            ImageUtil.viewToBitmap(textview),
            0,
            0
        )
        //添加水印到右底部
        watermarkBitmap = ImageUtil.createWaterMaskRightBottom(
            watermarkBitmap,
            waterBitmap,
            0,
            0
        )
        watermarkBitmap = ImageUtil.createWaterMaskLeftTop(
            watermarkBitmap,
            waterBitmap,
            0,
            0
        )
        watermarkBitmap = ImageUtil.createWaterMaskRightTop(
            watermarkBitmap,
            waterBitmap,
            0,
            0
        )

        picture.setImageBitmap(watermarkBitmap)
    }






}
