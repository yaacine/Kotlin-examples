package com.example.exo4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Prof_detail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prof_detail)


        val bun:Bundle? = intent.extras

        bun!!.let {

            (findViewById<TextView>(R.id.pro_nom)).text =  bun.getString("prof_nom")

            (findViewById<TextView>(R.id.pro_prenom)).text =  bun.getString("prof_prenom")

            (findViewById<TextView>(R.id.pro_grade)).text =  bun.getInt("prof_grade").toString()



        }
    }
}
