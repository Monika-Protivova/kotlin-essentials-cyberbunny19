package com.motycka.edu.lesson02

/*
Define String variables for two types of coffee: espresso and cappuccino.
*/
const val espresso = "Espresso"
const val cappuccino = "Cappuccino"

/*
Define Double variables for the prices of espresso and cappuccino.
*/
const val espressoPrice = 2.5
const val cappuccinoPrice = 3.0

fun variables(espressoQuantity: Int, cappuccinoQuantity: Int) {
    // Calculate total price based on quantities and prices
    val totalPrice: Double = espressoQuantity * espressoPrice + cappuccinoQuantity * cappuccinoPrice

    println("Total price for $espressoQuantity Espresso(s) and $cappuccinoQuantity Cappuccino(s): $totalPrice")
}

fun main(args: Array<String>) {
    // Count how many times espresso and cappuccino appear in args
    val espressoQuantity = args.count { it.equals(espresso, ignoreCase = true) }
    val cappuccinoQuantity = args.count { it.equals(cappuccino, ignoreCase = true) }

    variables(espressoQuantity = espressoQuantity, cappuccinoQuantity = cappuccinoQuantity)
}
