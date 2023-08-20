package com.example.springkotlin.domain.product.service

import com.example.springkotlin.domain.product.Product
import com.example.springkotlin.domain.product.ProductCommand
import com.example.springkotlin.domain.user.User
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.Mockito.any
import org.mockito.Mockito.`when`
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder


@ExtendWith(MockKExtension::class)
internal class ProductServiceImplTest {

    @MockK
    lateinit var productReader: ProductReader

    @MockK
    lateinit var productStore: ProductStore

    @InjectMockKs
    lateinit var productService: ProductServiceImpl

    @DisplayName("[ProductService] 상품을 추가한다.")
    @Test
    fun addProduct() {
        // given
        // 사용자 인증 Mocking
        val authentication: Authentication = Mockito.mock(Authentication::class.java)
        val securityContext = Mockito.mock(SecurityContext::class.java)
        `when`(securityContext.authentication).thenReturn(authentication)
        SecurityContextHolder.setContext(securityContext)
        val user = User(
                nickName = "test-nickname",
                credit = 0,
                m_password = "test-password"
        )
        `when`(authentication.principal).thenReturn(user)

        val testProductName = "test-product-name"
        val testProductCost = 100_000
        every { productStore.storeProduct(any()) } returns Product(
                name = testProductName,
                cost = testProductCost,
                user = user,
        )

        // when
        val result = productService.addProduct(ProductCommand.ProductAddCommand(
                name = testProductName,
                cost = testProductCost,
        ))

        // then
        assertEquals(testProductName, result.name)
        assertEquals(testProductCost, result.cost)
    }

    @DisplayName("[ProductService] 상품을 ID 로 조회한다.")
    @Test
    fun getProductWithProductId() {
        // given
        val testProductName = "test-product-name"
        val testProductCost = 100_000
        val user = User(
                nickName = "test-nickname",
                credit = 0,
                m_password = "test-password"
        )
        every { productReader.getProductWithProductId(any()) } returns Product(
                productId = 1L,
                name = testProductName,
                cost = testProductCost,
                user = user,
        )

        // when
        val result = productService.getProductWithProductId(1L)


        // then
        assertEquals(testProductName, result.name)
        assertEquals(testProductCost, result.cost)
    }

    @DisplayName("[ProductService] 모든 상품을 조회한다.")
    @Test
    fun getAllProducts() {
        // given
        val user = User(
                nickName = "test-nickname",
                credit = 0,
                m_password = "test-password"
        )
        val product1 = Product(
                productId = 1L,
                name = "test-product-name-1",
                cost = 100,
                user = user,
        )
        val product2 = Product(
                productId = 2L,
                name = "test-product-name-2",
                cost = 100,
                user = user,
        )
        val productList = mutableListOf(product1, product2)
        every { productReader.getAllProducts() } returns productList

        // when
        val result = productService.getAllProducts()


        // then
        assertEquals(2, result.size)
        assertNotNull(result.get(0))
        assertNotNull(result.get(1))
    }

    @DisplayName("[ProductService] 토큰으로 상품을 조회한다..")
    @Test
    fun getProductWithProductToken() {
        // given
        val productTestToken = "product_12321412412"
        val user = User(
                nickName = "test-nickname",
                credit = 0,
                m_password = "test-password"
        )
        val product = Product(
                productToken = productTestToken,
                productId = 1L,
                name = "test-product-name",
                cost = 100,
                user = user,
        )
        every { productReader.getProductWithProductToken(productTestToken) } returns product

        // when
        val result = productService.getProductWithProductToken(productTestToken)

        // then
        assertNotNull(result)
        assertEquals(1L, result.productId)
    }

    @DisplayName("[ProductService] ID로 상품을 삭제한다.")

    @Test
    fun deleteProductWithProductId() {
        //given
        val user = User(
                nickName = "test-nickname",
                credit = 0,
                m_password = "test-password"
        )
        val product = Product(
                productId = 1L,
                name = "test-product-name",
                cost = 100,
                user = user,
        )
        every { productReader.getProductWithProductId(1L) } returns product
        every { productStore.deleteProduct(product) } returns any()

        // when
        productService.deleteProductWithProductId(1L)

        // then
        verify { productStore.deleteProduct(product) }
    }
}