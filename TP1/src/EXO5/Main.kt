package EXO5

import EXO4.Compte
import EXO4.CompteDevis
import EXO4.CompteEparagne
import EXO4.CompteEpargneVip


object Calculateur{

fun calculerImposTotal(vararg items : ICalculImpos ): Double{


        var imposTotal: Double =0.0

        for (bien in items){
            imposTotal+= bien.calculerImpos()
        }

    return imposTotal
    }
}

fun main(){

    var compte1  = CompteDevis("nassim" , 100.0 , 2.0)
    var compte2  = CompteEparagne("nassim2" , 200.0 )
    var compte3  = CompteEpargneVip("nassim3" , 300.0 )

    var comptes = listOf<Compte>(compte1, compte2, compte3)


    var bien1 = Immauble(100.0)
    var bien2 = Immauble(200.0)
    var bien3 = Immauble(300.0)

    var biens = listOf<Bien>(bien1, bien2, bien3)

    var impos = Calculateur.calculerImposTotal( comptes ,  biens )

    print("le total des impots est  ${impos} ")
}
