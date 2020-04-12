package com.example.exo4

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exo4.code.seance
import kotlinx.android.synthetic.main.seance.view.*


class seanceAdapter(ls:List<seance>, cntx: Context) : RecyclerView.Adapter<seanceAdapter.MYViewHolder>() {

    var liste: List<seance> = ls
    var con: Context = cntx

    inner class MYViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun set(day: seance) {

            itemView.txt_deb.text = day.date_debut
            itemView.txt_fin.text = day.date_fin
            itemView.txt_module.text = day.module.nom

            itemView.setOnClickListener {


                if( (con.resources.configuration.orientation== Configuration.ORIENTATION_PORTRAIT)
                    &&(con.resources.configuration.screenWidthDp < 700)) {
                    val intent = Intent()
                    intent.setClass(con, Module_detaille::class.java)

                    intent.putExtra("nom_module", day.module.nom)
                    intent.putExtra("total", day.module.total)
                    intent.putExtra("prof_nom", day.module.prof.nom)
                    intent.putExtra("prof_prenom", day.module.prof.prenom)
                    intent.putExtra("prof_grade", day.module.prof.grade)

                    con.startActivity(intent)
                }
                else{

                    ((con as MainActivity).findViewById<TextView>(R.id.txt_nom_module2)).text =  day.module.nom

                    ((con as MainActivity).findViewById<TextView>(R.id.txt_total)).text =  day.module.total.toString()

                    ((con as MainActivity).findViewById<TextView>(R.id.txt_prof)).text =  day.module.prof.nom +" "+day.module.prof.prenom

                    ((con as MainActivity).findViewById<TextView>(R.id.txt_grade)).text =  day.module.prof.grade.toString()



                }


            }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MYViewHolder {
        val item = LayoutInflater.from(con).inflate(R.layout.seance, parent, false)

        return MYViewHolder(item)
    }

    override fun getItemCount(): Int {
        return liste.size
    }

    override fun onBindViewHolder(holder: MYViewHolder, position: Int) {
        val book = liste[position]
        holder.set(book)


    }
}