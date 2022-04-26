package com.example.springkotlin.domain.product

import com.example.springkotlin.config.common.TokenGenerator
import com.example.springkotlin.domain.BaseEntity
import com.example.springkotlin.domain.user.User
import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
class Product(

    private val PRODUCT_PREFIX: String = "prod_",

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val productId: Long? = null,
    var productToken: String = TokenGenerator.randomCharacterWithPrefix(PRODUCT_PREFIX),
    val name: String,
    var cost: Int,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    @JsonBackReference
    var user: User
    ) : BaseEntity() {
}