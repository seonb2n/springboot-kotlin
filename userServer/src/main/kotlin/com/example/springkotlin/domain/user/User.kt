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
    var credit: Int,
    @OneToMany(mappedBy = "user")
    var productSet: MutableSet<Product> = TreeSet()
    ) : BaseEntity() {

        fun addProduct(product: Product) {
            productSet.add(product)
        }
}