package com.github.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.github.myapplication.Gl.CameraActivity
import com.github.myapplication.LazyFragment.LazyActivity
import com.github.myapplication.ProxyMode.ProxyModeTextActivity
import com.github.myapplication.shenfenzhen.ShenFenZhengActivity
import com.github.myapplication.shuiyin.ShuiYinActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init(){
        lazy.setOnClickListener(this@MainActivity)
        proxy.setOnClickListener(this@MainActivity)
        douyin.setOnClickListener(this@MainActivity)
        shuiyin.setOnClickListener(this@MainActivity)
        shenfenzheng.setOnClickListener(this@MainActivity)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.lazy ->{
                val intent : Intent = Intent(this@MainActivity,LazyActivity::class.java)
                startActivity(intent)
            }
            R.id.proxy ->{
                val intent : Intent = Intent(this@MainActivity,ProxyModeTextActivity::class.java)
                startActivity(intent)
            }
            R.id.douyin ->{
                val intent : Intent = Intent(this@MainActivity,CameraActivity::class.java)
                startActivity(intent)
            }
            R.id.shuiyin ->{
                val intent : Intent = Intent(this@MainActivity,ShuiYinActivity::class.java)
                startActivity(intent)
            }
            R.id.shenfenzheng ->{
                Log.i("karson", "wo dao le tiao zhuan shen fen zheng ")
//                val intent : Intent = Intent(this@MainActivity,ShenFenZhengActivity::class.java)
//                startActivity(intent)
                ShenFenZhengActivity.openCertificateCamera(this@MainActivity)
            }
        }

    }

}
