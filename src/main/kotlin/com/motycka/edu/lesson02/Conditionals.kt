package com.motycka.edu.lesson02

const val ESPRESSO_PRICE = 2.5
const val DOUBLE_ESPRESSO_PRICE = 3.0
const val CAPPUCCINO_PRICE = 3.0
const val LATTE_PRICE = 3.5
const val AMERICANO_PRICE = 2.0
const val FLAT_WHITE_PRICE = 3.2

// 1. Get price based on item names
fun getPrice(item: String): Double {
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

fun conditionals() {
    val coffeeOrders = mapOf(
        1 to listOf(ESPRESSO, CAPPUCCINO, LATTE, AMERICANO),
        2 to listOf(ESPRESSO, DOUBLE_ESPRESSO, FLAT_WHITE)
    )

    coffeeOrders.forEach { orderId, items ->

        println("Processing Order ID: $orderId")
        println("Items: $items")

        // 3. Calculate total price for a list of items
        val prices = items.map { getPrice(it) }
        val totalBeforeDiscount = prices.sum()

        // 4. Apply discount if 3 or more items: cheapest one is free
        val discount = if (prices.size >= 3) prices.minOrNull() ?: 0.0 else 0.0

        val finalTotal = totalBeforeDiscount - discount

        // 5. Print the total price with discount applied
        println("Total price for Order ID $orderId: $finalTotal\n")
    }
}

fun main() {
    conditionals()
}
