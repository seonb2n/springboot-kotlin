package com.example.productserver.infrastructures.kafka

import com.example.productserver.domain.order.service.OrderService
import com.example.productserver.infrastructures.user.CreditUpdateDtoResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import java.io.IOException
import kotlin.jvm.Throws

@Service
class KafkaConsumer {

    @Autowired
    lateinit var orderService: OrderService

    @KafkaListener(topics = ["creditUpdate"], groupId = "order")
    @Throws(IOException::class)
    fun consume(response: CreditUpdateDtoResponse.Update){
        println("Consumed Message : " + response.isUpdated.toString())
        orderService.updateOrderWithOrderToken(response.productToken, response.isUpdated)
    }
}