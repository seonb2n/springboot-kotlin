package com.example.productserver.infrastructures.order

import com.example.productserver.domain.order.ProductOrder
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository: JpaRepository<ProductOrder, Long> {

    fun findProductOrderByProductToken(productToken: String): ProductOrder?

}