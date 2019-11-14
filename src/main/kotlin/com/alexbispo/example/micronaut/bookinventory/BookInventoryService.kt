package com.alexbispo.example.micronaut.bookinventory

import io.micronaut.configuration.rabbitmq.annotation.Queue
import io.micronaut.configuration.rabbitmq.annotation.RabbitListener;

@RabbitListener
class BookInventoryService {

    @Queue("iventory")
    fun stock(isbn: String): Boolean? = bookInventoryByIsbn(isbn)?.let { it.stock > 0 }

    private fun bookInventoryByIsbn(isbn: String): BookInventory? {
        if (isbn == "1491950358") {
            return BookInventory(isbn, 4)
        }

        if (isbn == "1680502395") {
            return BookInventory(isbn, 0)
        }

        return null
    }
}