package com.github.myapplication.ObserverText

class User :Observer{

    private var name:String = ""
    private var message:String = ""


    public fun setName(str: String){
        this.name = str
    }

    override fun Updata(str: Any) {
        this.message = str as String
        read()
    }

    private fun read(){
        println("$name 收到了：$message")
    }

}