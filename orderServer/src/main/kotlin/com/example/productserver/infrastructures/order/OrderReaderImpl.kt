package com.example.productserver.infrastructures.order

import com.example.productserver.domain.order.ProductOrder
import com.example.productserver.domain.order.service.OrderReader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.lang.RuntimeException

@Component
class OrderReaderImpl : OrderReader {

    @Autowired
    lateinit var orderRepository: OrderRepository

    override fun getOrderWithOrderToken(orderToken: String): ProductOrder {
        return orderRepository.findProductOrderByProductToken(orderToken)
            ?: throw RuntimeException("$orderToken can not found")
    }

}