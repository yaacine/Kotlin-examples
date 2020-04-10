package EXO4


    fun main(){
        var compte1  = CompteDevis("nassim" , 100.0 , 2.0)
        var compte2  = CompteEparagne("nassim2" , 200.0 )
        var compte3  = CompteEpargneVip("nassim3" , 300.0 )

        var comptes = listOf<Compte>(compte1, compte2, compte3)

        for (item in comptes){
            println(" compte numero ${item.numero}  ---> commission = ${item.calculerComission()}")
        }
    }


