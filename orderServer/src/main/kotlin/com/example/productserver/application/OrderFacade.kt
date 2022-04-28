package com.example.productserver.application

import com.example.productserver.domain.order.OrderCommand
import com.example.productserver.domain.order.OrderInfo
import com.example.productserver.domain.order.service.OrderService
import com.example.productserver.infrastructures.kafka.KafkaConsumer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrderFacade {

    @Autowired
    lateinit var orderService: OrderService

    fun registerOrder(orderRegisterCommand: OrderCommand.OrderRegisterCommand): OrderInfo.Main {
        return orderService.registerOrder(orderRegisterCommand)
    }

}