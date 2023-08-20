package com.example.springkotlin.domain.user.service

import com.example.springkotlin.domain.product.Product
import com.example.springkotlin.domain.product.service.ProductReader
import com.example.springkotlin.domain.user.User
import com.example.springkotlin.domain.user.UserCommand
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
internal class UserServiceImplTest {

    @MockK
    lateinit var userReader: UserReader

    @MockK
    lateinit var userStore: UserStore

    @MockK
    lateinit var productReader: ProductReader

    @InjectMockKs
    lateinit var userService: UserServiceImpl

    val userToken = "user_123456"
    val userName = "test_user_name"
    val userPassword = "test_user_password"
    val userCredit = 100_000
    val user = createUser()

    private fun createUser(): User {
        return User(
                userToken = userToken,
                nickName = userName,
                userPassword = userPassword,
                credit = userCredit,
        )
    }

    @DisplayName("[UserService] 사용자를 등록한다.")
    @Test
    fun registerUser() {

        every { userStore.storeUser(any()) } returns user

        // when
        val result = userService.registerUser(UserCommand.UserRegisterCommand(
                userNickName = userName,
                userCredit = userCredit,
                userPassword = userPassword,
        ))

        // then
        assertEquals(userName, result.userNickName)
        assertEquals(userCredit, result.userCredit)
        assertEquals(userPassword, result.userPassword)
    }

    @DisplayName("[UserService] 사용자 ID 로 사용자를 가져온다.")
    @Test
    fun getUserWithUserId() {
        // given
        every { userReader.getUserWithUserId(1L) } returns user


        // when
        val result = userService.getUserWithUserId(1L)

        // then
        assertEquals(userName, result.userNickName)
        assertEquals(userCredit, result.userCredit)
    }

    @DisplayName("[UserService] 사용자 이름으로 사용자를 가져온다.")
    @Test
    fun getUserWithUserNickName() {
        // given
        every { userReader.getUserWithUserNickName(userName) } returns user

        // when
        val result = userService.getUserWithUserNickName(userName)

        // then
        assertEquals(userName, result.userNickName)
        assertEquals(userCredit, result.userCredit)
    }

    @DisplayName("[UserService] 사용자 인증을 하는 Security 에서 사용하는 사용자 정보 조회")
    @Test
    fun loadUserByUsername() {
        // given
        every { userReader.getUserWithUserNickName(userName) } returns user

        // when
        val result = userService.loadUserByUsername(userName)

        // then
        assertEquals(userName, result.username)
    }

    @DisplayName("[UserService] 사용자 이름으로 존재 여부를 확인한다.")
    @Test
    fun isUserExist() {
        // given
        every { userReader.isUserExist(userName) } returns true

        // when
        val result = userService.isUserExist(userName)

        // then
        assertTrue(result)
    }

    @DisplayName("[UserService] 사용자의 Credit 이 상품 가격보다 높으면 credit 을 차감한다. - 성공")
    @Test
    fun updateUserCreditSuccess() {
        // given
        val productToken = "product_123456"
        val product = Product(
                productToken = productToken,
                productId = 1L,
                name = "test-product-name",
                cost = 100,
                user = user,
        )
        every { userReader.getUserWithUserToken(any()) } returns user
        every { productReader.getProductWithProductToken(any()) } returns product

        // when
        val result = userService.updateUserCredit(userToken, productToken)

        // then
        assertTrue(result)
    }

    @DisplayName("[UserService] 사용자의 Credit 이 상품 가격보다 높으면 credit 을 차감한다. - 실패")
    @Test
    fun updateUserCreditFail() {
        // given
        val productToken = "product_123456"
        val product = Product(
                productToken = productToken,
                productId = 1L,
                name = "test-product-name",
                cost = 100_000_000,
                user = user,
        )
        every { userReader.getUserWithUserToken(any()) } returns user
        every { productReader.getProductWithProductToken(any()) } returns product

        // when
        val result = userService.updateUserCredit(userToken, productToken)

        // then
        assertFalse(result)
    }
}