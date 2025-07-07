package com.example.basicactivity.Classbasic

fun printNotificationSummery(number: Int) {
    println(
        """
        You have $number notifications.
        Your phone is blowing up! You have 99+ notifications.
    """.trimIndent()
    )
}

val tempOptionNames = listOf(
    "Celsius-to-Fahrenheit",
    "Fahrenheit-to-Kelvin",
    "Kelvin-to-Celsius",
    "Celsius-to-Kelvin",
    "Fahrenheit-to-Celsius",
    "Kelvin-to-Fahrenheit"
)

fun tempConverter(temperatureOptions: String, temp: Double): String {
    val result: Double? = when (temperatureOptions) {
        tempOptionNames[0] -> (temp * 9 / 5) + 32
        tempOptionNames[1] -> (temp - 32) * 5 / 9 + 273.15
        tempOptionNames[2] -> temp - 273.15
        tempOptionNames[3] -> temp + 273.15
        tempOptionNames[4] -> (temp - 32) * 5 / 9
        tempOptionNames[5] -> (temp - 273.15) * 9 / 5 + 32
        else -> null
    }
    return String.format("%.2f", result ?: Double.NaN)
}

fun main() {
    val morningNotification = 51
    val eveningNotification = 100
    printNotificationSummery(morningNotification)
    printNotificationSummery(eveningNotification)

    println("${18.0} deg celcies = ${tempConverter("Celsius-to-Fahrenheit", 18.0)} deg fernenhight")
}