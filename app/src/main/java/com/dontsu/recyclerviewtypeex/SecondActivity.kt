
package com.dontsu.recyclerviewtypeex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.d("세컨", "${textView2.context}")
        Log.d("세컨", "${textView3.context}")
        Log.d("세컨", "$this , ${this.application}, ${this.applicationContext}, ${this.baseContext}")
    }
}
