package com.github.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.github.myapplication.LazyFragment.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init(){
        one.setOnClickListener(this)
        two.setOnClickListener(this)
        there.setOnClickListener(this)
        four.setOnClickListener(this)
        five.setOnClickListener(this)

        viewpager.adapter = MyPagerAdapter(supportFragmentManager, setfargment())
        viewpager.offscreenPageLimit = 4
    }

    private fun setfargment(): List<Fragment> {
        val list:MutableList<Fragment> = ArrayList()

        return list
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.one ->{
                viewpager.currentItem = 0
            }
            R.id.two ->{
                viewpager.currentItem = 1
            }
            R.id.there ->{
                viewpager.currentItem = 2
            }
            R.id.four ->{
                viewpager.currentItem = 3
            }
            R.id.five ->{
                viewpager.currentItem = 4
            }
        }
    }


}
