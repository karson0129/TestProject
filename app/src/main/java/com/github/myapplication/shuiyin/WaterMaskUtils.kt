package com.github.myapplication.shuiyin

import android.graphics.Bitmap
import android.graphics.Canvas

class WaterMaskUtils {



//    private static Bitmap createWaterMaskBitmap(Bitmap src, Bitmap watermark, int paddingLeft, int paddingTop) {
//        if (src == null) {
//            return null;
//        }
//        int width = src.getWidth();
//        int height = src.getHeight();
//        //创建一个bitmap
//        Bitmap newb = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);// 创建一个新的和SRC长度宽度一样的位图
//        //将该图片作为画布
//        Canvas canvas = new Canvas(newb);
//        //在画布 0，0坐标上开始绘制原始图片
//        canvas.drawBitmap(src, 0, 0, null);
//        //在画布上绘制水印图片
//        canvas.drawBitmap(watermark, paddingLeft, paddingTop, null);
//        // 保存
//        canvas.save(Canvas.ALL_SAVE_FLAG);
//        // 存储
//        canvas.restore();
//        return newb;
//    }

    /***
     *
     */
    public fun createWaterMaskBitmap(src:Bitmap,watermark:Bitmap,paddingLeft:Float,paddingTop:Float):Bitmap{
        val width:Int = src?.width
        val height:Int = src?.height

        //创建一个Bitmap
        //创建一个新得和SRC长宽度一样得位图
        var newb:Bitmap = Bitmap.createBitmap(width,height,Bitmap.Config.RGB_565)
        //将该图片作为画布
        var canvas:Canvas = Canvas(newb)
        //在画布 0，0坐标上开始绘制原始图片
        canvas.drawBitmap(src,0f,0f,null)
        //在画布上绘制水印图片
        canvas.drawBitmap(watermark, paddingLeft, paddingTop, null)
        // 保存
        canvas.save()
        // 存储
        canvas.restore()
        return newb
    }

}