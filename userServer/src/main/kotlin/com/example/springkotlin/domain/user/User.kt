package com.example.springkotlin.domain.user

import com.example.springkotlin.domain.BaseEntity
import com.example.springkotlin.domain.product.Product
import java.util.*
import javax.persistence.*

@Entity
class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: Long? = null,
    var nickName: String,
    @OneToMany(mappedBy = "user")
    var productList: MutableSet<Product> = TreeSet()
    ) : BaseEntity() {

}