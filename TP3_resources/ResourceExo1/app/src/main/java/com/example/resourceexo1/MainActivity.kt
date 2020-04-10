package com.example.resourceexo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rnds = (0..50).random()

        var nbTrys = 3
        reste.text= "Il reste $nbTrys tentatives"


        goBtn.setOnClickListener{
            reste.text= "Il reste ${nbTrys.toString()} tentatives"
            var entedNb = entredNumber.text.toString().toInt()
            Log.i("MyActivity", "MyClass.getView() — try N° $nbTrys   user entred $entedNb")
            if (entedNb == rnds){
                message.text = "Réussi"
                entredNumber.setText("")

                nbTrys =0
                reste.text= "Il reste $nbTrys tentatives"

            }
            else{
                message.text = "Non! Essayez à nouveau"
                entredNumber.setText("")

                nbTrys --
                reste.text= "Il reste $nbTrys tentatives"

                if (nbTrys<=0){
                    message.text = "Partie terminée , cliquez sur retry pour rejouer"
                    entredNumber.setText("")

                }
            }
        }

        retryBtn.setOnClickListener{
            entredNumber.setText("")
            rnds = (0..50).random()
            nbTrys =3
            reste.text= "Il reste $nbTrys tentatives"

        }
    }
}
