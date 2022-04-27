package com.example.productserver.interfaces

import com.example.productserver.domain.order.OrderCommand
import com.example.productserver.domain.order.OrderInfo

class OrderDto {

    class RegisterRequest(
        var jwtToken: String,
        var userToken: String,
        var productToken: String
    ) {
        fun toCommand() : OrderCommand.OrderRegisterCommand {
            return OrderCommand.OrderRegisterCommand(
                jwtToken = jwtToken,
                userToken = userToken,
                productToken = productToken
            )
        }
    }

    class RegisterResponse(orderInfo: OrderInfo.Main) {
        var orderToken = orderInfo.orderToken
        var productToken = orderInfo.productToken
        var isCompleted = orderInfo.isOrderCompleted
    }

}