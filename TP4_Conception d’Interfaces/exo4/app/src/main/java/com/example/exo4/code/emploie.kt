package com.example.exo4.code



object store {

    val temps = listOf<day>(
        day("2020-05-26", listOf(
            seance("8.30","10.00",module("ml",1,enseignant("p1","p2",5))),
            seance("10.30","12.00",module("tdm",12,enseignant("prof5","prenom",4))),
            seance("13.00","15.00",module("bdd",1,enseignant("nomProf","PrenomPro",8))),
            seance("15.00","14.00",module("hlm",8,enseignant("p1","p2",1)))
        )),
        day("2020-05-27", listOf(
            seance("8.30","10.00",module("ml",155,enseignant("p1","p2",5))),
            seance("10.30","12.00",module("tdm",13,enseignant("prof5","prenom",4))),
            seance("13.00","15.00",module("bdd",15,enseignant("nomProf","PrenomPro",8)))

        )),
        day("2020-05-28", listOf(
            seance("8.30","10.00",module("ml",9,enseignant("p1","p2",5))),
            seance("10.30","12.00",module("tdm",15,enseignant("prof5","prenom",4))),
            seance("13.00","15.00",module("bdd",15,enseignant("nomProf","PrenomPro",8))),
            seance("15.00","14.00",module("hlm",15,enseignant("p1","p2",1)))
        ))



    )


}