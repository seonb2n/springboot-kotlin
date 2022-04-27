package com.example.productserver.domain.order.service

import com.example.productserver.domain.order.OrderCommand
import com.example.productserver.domain.order.OrderInfo

interface OrderService {

    fun registerOrder(orderAddCommand: OrderCommand.OrderRegisterCommand): OrderInfo.Main

}