package com.example.springkotlin

import com.example.springkotlin.domain.user.UserCommand
import com.example.springkotlin.domain.user.service.UserService
import com.example.springkotlin.infrastructures.user.UserRepository
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
        val registerUser: UserCommand.UserRegisterCommand = UserCommand.UserRegisterCommand(
            userNickName = "test-user",
            userCredit = 3000,
            userPassword = "1234"
        )

        val user = userService.registerUser(registerUser)

        println(user.userId)

        val userId = user.userId

        val user2 = userId?.let { userService.getUserWithUserId(it) }

        Assertions.assertEquals(user.userNickName, user2?.userNickName)
    }
}