package EXO4

open class CompteEparagne(numero: String, solde: Double ): Compte(numero = numero , solde = solde) {

    override fun calculerComission(): Int = (this.solde *0.1).toInt()
}