package EXO5

class Immauble(valeur:Double) : Bien(valeur){

    override fun calculerImpos(): Double {
        return (valeur * 0.1).toDouble()
    }
}