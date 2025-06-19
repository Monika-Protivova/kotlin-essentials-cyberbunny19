package com.motycka.edu.lesson02

/*
 Coffee Shop Menu
 */

const val ESPRESSO = "Espresso"
const val DOUBLE_ESPRESSO = "Double Espresso"
const val CAPPUCCINO = "Cappuccino"
const val LATTE = "Latte"
const val MACCHIATO = "Macchiato"
const val MOCHA = "Mocha"
const val FLAT_WHITE = "Flat White"
const val AMERICANO = "Americano"

// 1 & 2. Create and initialize the list with coffee menu items
val coffeeMenu: List<String> = listOf(
    ESPRESSO,
    DOUBLE_ESPRESSO,
    CAPPUCCINO,
    LATTE,
    MACCHIATO,
    MOCHA,
    FLAT_WHITE,
    AMERICANO
)

fun collections() {
    // 3. Define a mutable map to store orders
    val orders: MutableMap<Int, List<String>> = mutableMapOf()

    println("\nWelcome to the Coffee Shop! Here is our menu:")

    // 4. Print the coffee menu items
    coffeeMenu.forEachIndexed { index, item ->
        println("${index + 1}. $item")
    }

    // 5. Create order1: 1x ESPRESSO, 2x CAPPUCCINO, and 1x AMERICANO
    val order1 = listOf(ESPRESSO, CAPPUCCINO, CAPPUCCINO, AMERICANO)

    // 6. Add order1 to orders map
    orders[1] = order1

    // 7. Create order2: 1x ESPRESSO, 1x DOUBLE_ESPRESSO, and 1x FLAT_WHITE
    val order2 = listOf(ESPRESSO, DOUBLE_ESPRESSO, FLAT_WHITE)

    // 8. Add order2 to orders map
    orders[2] = order2

    // 9. Print the orders placed
    println("\nOrders placed:")
    orders.forEach {
        println("Order ID: ${it.key}, Items: ${it.value}")
    }
}

fun main() {
    collections()
}
