package com.example.exo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class book_detail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_detail)

        val bun:Bundle? = intent.extras

        bun!!.let {

            (findViewById<TextView>(R.id.txt_title)).text =  bun.getString("titre")

            (findViewById<TextView>(R.id.txt_auteur)).text =  bun.getString("auteur")

            (findViewById<TextView>(R.id.txt_resume)).text =  bun.getString("resume")

            (findViewById<ImageView>(R.id.img_book)).setImageResource(  bun.getInt("photo"))

            (findViewById<ImageView>(R.id.img_auteur)).setImageResource(  bun.getInt("auteur_photo"))

        }


    }
}
