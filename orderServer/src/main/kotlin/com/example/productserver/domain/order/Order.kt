package com.example.productserver.domain.order

import com.example.productserver.common.TokenGenerator
import com.example.productserver.domain.BaseEntity
import javax.persistence.*

@Entity
class Order(

    private val ORDER_PREFIX: String = "order_",
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val orderId: Long? = null,
    val orderToken: String = TokenGenerator.randomCharacterWithPrefix(ORDER_PREFIX),
    val userToken: String,
    val productToken: String

): BaseEntity() {
}