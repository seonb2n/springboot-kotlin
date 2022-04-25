package com.example.springkotlin.domain.product

import com.example.springkotlin.domain.user.User

class ProductCommand {

    class ProductAddCommand(
        private val name: String,
        private val amount: Int,
        private val cost: Int,
    ) {
        fun toEntity(user: User): Product {
            return Product(
                name = name,
                amount = amount,
                cost = cost,
                user = user
            )
        }
    }

    class ProductIdCommand (
        val productId: Long
    )
}