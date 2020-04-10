package EXO4

abstract class Compte(numero: String, solde: Double) {


    private var _numero : String =""
    private var  _solde : Double =0.0

    public var numero:String
        get() = this._numero
        set(numero){
            this._numero = numero
        }

    public var solde:Double
        get() = this._solde
        set(solde){
            this._solde = solde
        }


    abstract fun calculerComission(): Int

    init {
        this._numero = numero
        this._solde = solde
    }
}