package EXO4

class CompteDevis(numero: String, solde: Double , taux: Double): Compte(numero = numero , solde = solde) {

    private var taux :Double =0.0

    override fun calculerComission(): Int = (this.solde * taux  *0.2).toInt()
}