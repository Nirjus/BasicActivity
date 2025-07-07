package com.example.basicactivity.Classbasic

val trick: () -> Unit = {
    println("I trick in the game")
}

val treat:() -> Unit = {
    print("I gave treat to my poor friends")
}

fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)? = null):()-> Unit{
    if(isTrick){
        return trick
    }else{
        if(extraTreat != null) {
            println(extraTreat(5))
        }
        return treat
    }
}

fun main(){
    val tera = trick
    tera()
    trick()
  println("================ ⛔ ================")
    val numTreat:(Int) -> String = {
         "$it is a string return"
    }
    val trickFun = trickOrTreat(true, extraTreat = {numTreat(15)})
    val treatFun = trickOrTreat(false, {numTreat(25)})
    val noTreatFun = trickOrTreat(false)
    trickFun()
    treatFun()
    noTreatFun()
    repeat(5, action = {
        noTreatFun()
        println()
    })
}