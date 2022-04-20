package com.example.springkotlin

import com.example.springkotlin.domain.product.Product
import com.example.springkotlin.domain.user.User
import com.example.springkotlin.domain.user.UserCommand
import com.example.springkotlin.domain.user.service.UserService
import com.example.springkotlin.infrastructure.user.UserRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserTest {

    @Autowired
    private lateinit var userService: UserService

    @Autowired
    private lateinit var userRepository: UserRepository


    @Test
    fun userCreateTest() {
        val registerUser: UserCommand.RegisterUser = UserCommand.RegisterUser(
            userNickName = "test-user",
            userCredit = 3000
        )

        val user = userService.registerUser(registerUser)

        println(user.userId)

        val userId = user.userId

        val user2 = userId?.let { userService.getUserWithUserId(it) }

        println(user2?.userNickName)
    }
}