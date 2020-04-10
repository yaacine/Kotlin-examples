package com.example.resourcesexo3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val descriptions = resources.getStringArray(R.array.description)
        val names = resources.getStringArray(R.array.name)
        val imageIds = resources.obtainTypedArray(R.array.imageid)
        // val imageIds = resources.getIntArray(R.array.imageid)

        var currentIndex =0;
        nextBtn.setOnClickListener{
            currentIndex = (currentIndex+1 )%2
            println(currentIndex)
            nameTxt.text = names[currentIndex]
            descriptionTxt.text = descriptions[currentIndex]
            imageView.setImageResource(imageIds.getResourceId(currentIndex , 0))
        }


        nameTxt.text = names[currentIndex]
        descriptionTxt.text = descriptions[currentIndex]
        imageView.setImageResource(imageIds.getResourceId(currentIndex , 0))
    }
}
