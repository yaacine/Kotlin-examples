package com.example.exo2

import android.content.Context
import android.content.res.Configuration
import android.content.Intent as Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.book_item.view.*


class BookAdapter(ls:List<Book>,cntx:Context) : RecyclerView.Adapter<BookAdapter.MYViewHolder>() {

    inner class MYViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun set(book:Book){
            itemView.book_title.text = book.title
            itemView.imageView.setImageResource(book.photo)
            itemView.setOnClickListener {

                if( (con.resources.configuration.orientation== Configuration.ORIENTATION_PORTRAIT)
                    &&(con.resources.configuration.screenWidthDp < 700)) {
                    val intent = Intent()
                    intent.setClass(con, book_detail::class.java)

                    intent.putExtra("auteur", book.auteur)
                    intent.putExtra("titre", book.title)
                    intent.putExtra("resume", book.resume)
                    intent.putExtra("photo", book.photo)
                    intent.putExtra("auteur_photo", book.auteur_photo)

                    con.startActivity(intent)
                }
                else{

                    ((con as MainActivity).findViewById<TextView>(R.id.txt_title)).text =  book.title

                    ((con as MainActivity).findViewById<TextView>(R.id.txt_auteur)).text =  book.auteur

                    ((con as MainActivity).findViewById<TextView>(R.id.txt_resume)).text = book.resume

                    ((con as MainActivity).findViewById<ImageView>(R.id.img_book)).setImageResource(  book.photo)

                    ((con as MainActivity).findViewById<ImageView>(R.id.img_auteur)).setImageResource(  book.auteur_photo)


                }
            }
        }
    }


    var liste:List<Book> = ls
    var con : Context = cntx
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MYViewHolder {
       val item  =  LayoutInflater.from(con).inflate(R.layout.book_item,parent,false)

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