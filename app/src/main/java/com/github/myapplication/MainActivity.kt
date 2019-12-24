package com.github.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.github.myapplication.LazyFragment.*
import com.github.myapplication.ProxyMode.ProxyModeTextActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.reflect.KClass

class MainActivity : AppCompatActivity(),View.OnClickListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init(){
        lazy.setOnClickListener(this@MainActivity)
        proxy.setOnClickListener(this@MainActivity)
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
        }
    }

}
