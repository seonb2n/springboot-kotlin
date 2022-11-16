package com.example.springkotlin

import com.example.springkotlin.domain.product.service.ProductReader
import com.example.springkotlin.domain.user.UserCommand
import com.example.springkotlin.domain.user.service.UserReader
import com.example.springkotlin.domain.user.service.UserService
import com.example.springkotlin.domain.user.service.UserStore
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.BDDMockito
import org.mockito.Mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserTest {

    @Autowired
    private lateinit var userService: UserService

    @Mock
    private lateinit var userReader: UserReader

    @MockkBean
    private lateinit var userStore: UserStore

    @Mock
    private lateinit var productReader: ProductReader

    @Test
    fun userCreateTest() {
        //given
        val registerUser: UserCommand.UserRegisterCommand = UserCommand.UserRegisterCommand(
            userNickName = "test-user",
            userCredit = 3000,
            userPassword = "1234"
        )
        every { userStore.storeUser(any())} returns registerUser.toEntity()

        //when
        val user = userService.registerUser(registerUser)

        //then
        Assertions.assertEquals("test-user", user.userNickName)
    }

}