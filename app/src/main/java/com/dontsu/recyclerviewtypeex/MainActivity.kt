package com.dontsu.recyclerviewtypeex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

/*
*
* android.app.Application@670ba98, android.app.Application@670ba98, android.app.ContextImpl@69f2f1 메인 액티비티
android.app.Application@670ba98, android.app.Application@670ba98, android.app.ContextImpl@91516d2 세컨드 액티비티

두 액비티비티의 application, applicationContext 둘은 정확히 같다.
그런데, baseContext는 다르다.
그리고 baseContext는, 해당 액티비티의 xml의 뷰 view.context와는 또 다르다.

한 액티비티의 XML에 부착되어 있는 모든 뷰들은, 동일한 context주소값을 가진다.
view.context에 접근했을때만 해당된다.
* 그리고 view.context는 this와 동일한 주소값을 가진다.

그런데,

이게 B라는 액티비티에서 찍으면 view.context의 값은 다르다.
그러니까 뷰들의 컨텍스트는 그 뷰가 있는 xml의 context라고 생각하면 된다.

또한 각 액티비티마다 baseContext는 다르다.
모든 액티비티의 application 과 applicationContext는 주소값이 동일하다.

* */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("퍼스트", "$this , ${this.application}, ${this.applicationContext}, ${this.baseContext}")

        val array = arrayListOf(0, 1) //나중에 뷰타입 구분에 쓰임

        val listAdapter = ListAdapter(array)
        recyclerView?.apply {
            Log.d("어댑터", "메인에서 ${recyclerView.context}")
            Log.d("어댑터", "메인에서 ${textView.context}")
            Log.d("어댑터", "메인에서 $recyclerView")
            layoutManager = LinearLayoutManager(context) //뷰의 배치 방향을 담당, 레이아웃매너지를 통해 내가 만든 뷰가 채워짐
            adapter = listAdapter
        }

    }

    fun onStartActivity(v: View) {
        Log.d("액티비티변경", "$v , ${v.context}")
        val intent = Intent(this@MainActivity, SecondActivity::class.java)
        startActivity(intent)
    }

}
