package com.example.springkotlin.domain.product

import com.example.springkotlin.domain.user.User
import com.example.springkotlin.domain.user.UserInfo

class ProductCommand {

    class ProductAddCommand(
        private val name: String,
        private val cost: Int,
    ) {
        fun toEntity(user: User): Product {
            return Product(
                name = name,
                cost = cost,
                user = user
            )
        }
    }

    class ProductIdCommand (
        val productId: Long
    )
}