package EXO4
import EXO5.*
class CompteEpargneVip (numero: String, solde: Double ): CompteEparagne(numero = numero , solde = solde) , ICalculImpos {

    override fun calculerComission(): Int {

        return  (this.solde  *0.2).toInt()
    }

    override fun calculerImpos(): Double {
        return  (this.solde  *0.2).toDouble()
    }


}