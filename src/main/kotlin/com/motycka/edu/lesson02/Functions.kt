package com.motycka.edu.lesson02

// Global map to store orders
val coffeeOrders = mutableMapOf<Int, List<String>>()
var nextOrderId = 1

fun main() {
    // Test calls
    println("Change: ${processOrder(listOf(ESPRESSO, CAPPUCCINO, CAPPUCCINO, AMERICANO), 20.0)}\n")
    println("Change: ${processOrder(listOf(ESPRESSO, FLAT_WHITE, AMERICANO), 10.0)}\n")
    // println("Change: ${processOrder(listOf(ESPRESSO, ESPRESSO, DOUBLE_ESPRESSO), 5.0)}\n")
}

fun processOrder(items: List<String>, payment: Double): Double {
    val orderId = placeOrder(items)
    val totalToPay = payOrder(orderId)

    if (payment < totalToPay) {
        throw IllegalArgumentException("Insufficient payment. Required: $totalToPay, Provided: $payment")
    }

    val change = payment - totalToPay
    completeOrder(orderId)

    return change
}

fun placeOrder(items: List<String>): Int {
    val orderId = nextOrderId++
    coffeeOrders[orderId] = items
    println("Order placed. ID: $orderId, Items: $items")
    return orderId
}

fun payOrder(orderId: Int): Double {
    val items = coffeeOrders[orderId] ?: error("Order ID not found.")
    val prices = items.map { getPrice(it) }
    val total = prices.sum()
    val discount = if (items.size >= 3) prices.minOrNull() ?: 0.0 else 0.0
    val totalAfterDiscount = total - discount
    println("Total for Order ID $orderId (discount applied if any): $totalAfterDiscount")
    return totalAfterDiscount
}

fun completeOrder(orderId: Int) {
    println("Order $orderId completed. Thank you!\n")
}

fun getCoffeePrice(item: String): Double {
    return when (item) {
        ESPRESSO -> ESPRESSO_PRICE
        DOUBLE_ESPRESSO -> DOUBLE_ESPRESSO_PRICE
        CAPPUCCINO -> CAPPUCCINO_PRICE
        LATTE -> LATTE_PRICE
        AMERICANO -> AMERICANO_PRICE
        FLAT_WHITE -> FLAT_WHITE_PRICE
        else -> 0.0
    }
}
