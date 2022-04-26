package com.example.productserver.domain.order

class OrderCommand {

    class OrderAddCommand(
        private val userToken: String,
        private val productToken: String
    ) {
        fun toEntity(): Order {
            return Order(
                userToken = userToken,
                productToken = productToken
            )
        }
    }

}