package EXO5

abstract class Bien (valeur: Double) {

    private var _valeur :Double =0.0

    public var valeur :Double
        get() = this._valeur
        set(valeur){
            this._valeur = valeur
        }


    init {
        this._valeur =  valeur
    }
}