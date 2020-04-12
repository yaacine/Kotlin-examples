package com.example.exo4

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exo4.code.day
import kotlinx.android.synthetic.main.one_day.view.*

class dayAdapter(ls:List<day>, cntx: Context) : RecyclerView.Adapter<dayAdapter.MYViewHolder>() {


    private val viewPool = RecyclerView.RecycledViewPool()

    inner class MYViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclev:RecyclerView = itemView.list_seance
        val txt:TextView = itemView.title_day

        fun set12(day: day) {
            txt.text = day.day
        }
    }


    var liste: List<day> = ls
    var con: Context = cntx
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MYViewHolder {
        val item = LayoutInflater.from(con).inflate(R.layout.one_day, parent, false)

        return MYViewHolder(item)
    }

    override fun getItemCount(): Int {
        return liste.size
    }

    override fun onBindViewHolder(holder: MYViewHolder, position: Int) {
        val book = liste[position]

        holder.set12(book)

        val childLay = LinearLayoutManager(holder.recyclev.context,RecyclerView.VERTICAL,false)
        holder.recyclev.apply {
            layoutManager = childLay
            adapter = seanceAdapter(book.ls,con)
            setRecycledViewPool(viewPool)
        }

    }
}