package EXO4

class CompteEpargneVip (numero: String, solde: Double ): CompteEparagne(numero = numero , solde = solde) {

    override fun calculerComission(): Int {

        return  (super.solde  *0.2).toInt()
    }
}