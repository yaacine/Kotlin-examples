package com.example.exo2

data class Book(var title:String , var resume:String , var auteur_photo:Int , var auteur:String , var photo:Int){

}

object Store {
    val books = listOf<Book>(
        Book("introduction ", "iygiu  v984\ngmiuh", R.drawable.ic_launcher_foreground, "noone", R.drawable.ic_launcher_foreground) ,
        Book("introduction to bdd", "iygi65496iuh", R.drawable.ic_launcher_foreground, "camus", R.drawable.ic_launcher_background) ,
        Book("math", "b=description detaillé", R.drawable.ic_launcher_foreground, "techoulks", R.drawable.ic_launcher_foreground) ,
        Book("introduction to ml", "iyh", R.drawable.ic_launcher_foreground, "write", R.drawable.ic_launcher_background) ,

        Book("introduction to ml", "new book", R.drawable.ic_launcher_foreground, "techoulks", R.drawable.ic_launcher_foreground) ,
        Book("physique", "iygiugmiuh", R.drawable.ic_launcher_foreground, "me", R.drawable.ic_launcher_background) ,
        Book("introduction to ml", "6541miuh", R.drawable.ic_launcher_foreground, "hello world", R.drawable.ic_launcher_foreground) ,
        Book("introduction to ml", "iygiugmiuh", R.drawable.ic_launcher_foreground, "test", R.drawable.ic_launcher_background)

        )
}