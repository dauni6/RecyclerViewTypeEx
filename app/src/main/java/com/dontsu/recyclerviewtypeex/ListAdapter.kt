package com.dontsu.recyclerviewtypeex

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//어댑터가 뷰 홀더를 만든다.

class ListAdapter(private val array: ArrayList<Int>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        Log.d("어댑터" , "getItemCount()")
        return array.size
    }

    //뷰가 다르다면 뷰타입으로 구분해줘야 된다. 내가 만든 아이템뷰가 다른 모양일 수 있으니까!
    override fun getItemViewType(position: Int): Int {
        Log.d("어댑터" , "getItemViewType() $position") //인덱스 순서로 알아서 position이 들어간다.
        return array[position]
    }

    //뷰 홀더 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.d("어댑터" , "onCreateViewHolder() $parent , ${parent.context}")
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            0 -> {
                val view = inflater.inflate(R.layout.view_item01, parent, false)
                InfoViewHolder(view)
            }

            else -> {
                val view = inflater.inflate(R.layout.view_item02, parent, false)
                FoodViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is InfoViewHolder -> {
                Log.d("어댑터" , "onBindViewHolder() ${holder.itemView.context} , ${holder.itemViewType},  $holder")
                //정보
            }
            is FoodViewHolder -> {
                Log.d("어댑터" , "onBindViewHolder() ${holder.itemView} , ${holder.itemViewType},  $holder")
                //음식
            }
        }
    }

}

//뷰는 뷰 홀더 객체에 의해 표현된다.
class InfoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val name = view.findViewById<TextView>(R.id.item_name)
    private val grade = view.findViewById<TextView>(R.id.item_grade)
    private val region = view.findViewById<TextView>(R.id.item_region)
}

class FoodViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val food = view.findViewById<TextView>(R.id.item_food)

}
