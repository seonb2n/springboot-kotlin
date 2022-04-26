package com.example.springkotlin.infrastructures.product

import com.example.springkotlin.domain.product.Product
import com.example.springkotlin.domain.user.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProductRepository: JpaRepository<Product, Long> {

    fun findProductByProductId(productId: Long): Product
    fun findProductsByUser(user: User): TreeSet<Product>
}