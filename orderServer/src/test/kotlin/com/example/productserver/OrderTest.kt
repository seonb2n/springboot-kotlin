package com.example.productserver

import com.example.productserver.domain.order.ProductOrder
import com.example.productserver.domain.order.service.OrderStore
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class OrderTest {

    @Autowired
    private lateinit var orderStore: OrderStore

    @Test
    fun orderCreateTest() {
        val order = ProductOrder(
            productToken = "prod_",
            userToken = "user_"
        )

        orderStore.storeOrder(order)

        println(order.orderId)
    }
}