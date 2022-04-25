package com.example.springkotlin.domain.product

import com.example.springkotlin.domain.BaseEntity
import com.example.springkotlin.domain.user.User
import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val productId: Long? = null,
    val name: String,
    var amount: Int? = 0,
    var cost: Int,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    @JsonBackReference
    var user: User
    ) : BaseEntity() {
}