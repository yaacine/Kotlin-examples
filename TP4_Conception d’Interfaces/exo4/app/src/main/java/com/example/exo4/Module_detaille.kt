package com.example.exo4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Module_detaille : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_detaille)

        val bun:Bundle? = intent.extras

        bun!!.let {

            (findViewById<TextView>(R.id.txt_nom_module2)).text =  bun.getString("nom_module")

            (findViewById<TextView>(R.id.txt_total)).text =  bun.getInt("total").toString()

            (findViewById<TextView>(R.id.txt_prof)).text =  bun.getString("prof_nom")

            (findViewById<Button>(R.id.button_def)).setOnClickListener {


                intent.setClass(this, Prof_detail::class.java)
                this.startActivity(intent)
            }

        }

    }
}
