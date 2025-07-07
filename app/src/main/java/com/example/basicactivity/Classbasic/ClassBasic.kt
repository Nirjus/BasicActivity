package com.example.basicactivity.Classbasic

open class Animal(val species: String, var category: String){
    var type = "normal"
    var life: Int = 0
        get() = field

    fun eat(){
        println("This animal can eat")
    }
    fun getInfo(){
        println("$species is under $category")
    }
    open fun sleep(){
        println("This animal is sleeping")
    }
}
class Humans(species: String, category: String): Animal(species, category){

    fun info(){
        type = "Human"
        life = 100
        category = "Man"
        println("I am a $type and I am live $life years")
    }
    var speakerVolume = 2
        get() = field
        set(value) {
            if(value in 0..100) field = value
        }

    var channelNumber = 2
        get() = field
        set(value) {
            if(value in 0..100) field = value
        }

    fun increaseVolume(){
        speakerVolume ++
        println("My volume is increasing")
    }
    fun nextChannel(){
        channelNumber++
        println("Next channel")
    }
    override fun sleep(){

    }

}
class SmartDevice {
    var name = "Android TV"
        get() = field
        set(value) {
            field = value
        }
    val category = "Smart TV"
    var deviseStatus = "online"

    fun turnOn(){
        println("Smart device is turn on")
    }
    fun turnOff(){
        println("Smart device is turn off")
    }

}

fun main(){
    val smartDevice = SmartDevice()
    val dog = Animal("Dog", "Homi")

    println("My device name ${smartDevice.name}")
    smartDevice.name = "Android phone"
    println("My device name ${smartDevice.name}")
    smartDevice.turnOn()
    smartDevice.turnOff()

    dog.getInfo()
    dog.eat()

    val prakash = Humans("homosapence", category = "Running")
    prakash.info()
}