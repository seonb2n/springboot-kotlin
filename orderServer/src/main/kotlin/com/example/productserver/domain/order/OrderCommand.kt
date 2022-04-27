package com.example.productserver.domain.order

class OrderCommand {

    class OrderRegisterCommand(
        val jwtToken: String,
        val userToken: String,
        val productToken: String
    ) {
        fun toEntity(): ProductOrder {
            return ProductOrder(
                userToken = userToken,
                productToken = productToken
            )
        }
    }

}