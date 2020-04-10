package EXO5

class Terrain (valeur:Double) : Bien(valeur){
    override fun calculerImpos(): Double {
        return (valeur * 0.1).toDouble()
    }
}