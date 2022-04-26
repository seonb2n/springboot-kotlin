package com.example.productserver.infrastructures.order

import com.example.productserver.domain.order.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository: JpaRepository<Order, Long> {
}