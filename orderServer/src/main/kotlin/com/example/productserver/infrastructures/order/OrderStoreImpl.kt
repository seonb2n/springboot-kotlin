package com.example.productserver.infrastructures.order

import com.example.productserver.domain.order.ProductOrder
import com.example.productserver.domain.order.service.OrderStore
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class OrderStoreImpl: OrderStore {

    @Autowired
    lateinit var orderRepository: OrderRepository

    override fun storeOrder(order: ProductOrder): ProductOrder {
        return orderRepository.save(order)
    }
}