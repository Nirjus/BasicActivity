package com.example.basicactivity.Classbasic

val trick:()-> Unit = {
    println("I trick in the game")
}

val treat:() -> Unit = {
    print("I gave treat to my poor friends")
}

fun trickOrTreat(isTrick: Boolean, extraTreat: (Int) -> String):()-> Unit{
    if(isTrick){
        return trick
    }else{
        println(extraTreat(5))
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
    trickFun()
    treatFun()
}