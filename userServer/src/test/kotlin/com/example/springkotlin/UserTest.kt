package com.example.springkotlin

import com.example.springkotlin.domain.product.Product
import com.example.springkotlin.domain.user.User
import org.junit.jupiter.api.Test

class UserTest {
    @Test
    fun userCreateTest() {
        val user = User(
            nickName = "test-user",
            credit = 3000
        )

        val product = Product (
            user = user,
            name = "test-product",
            cost = 300,
            amount = 3
        )

        println(user.userId)
        println(user.createdAt)
        println(user.updatedAt)
        println(product.productId)
        println(product.createdAt)
        println(product.updatedAt)
    }
}