package com.example.springkotlin.infrastructures.support

import com.example.springkotlin.application.product.ProductFacade
import com.example.springkotlin.application.user.UserFacade
import com.example.springkotlin.domain.product.ProductCommand
import com.example.springkotlin.domain.product.service.ProductReader
import com.example.springkotlin.domain.product.service.ProductStore
import com.example.springkotlin.domain.user.UserCommand
import com.example.springkotlin.domain.user.service.UserStore
import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@Component
@Profile("test")
class DBInit: CommandLineRunner {

    @Autowired
    lateinit var userFacade: UserFacade

    @Autowired
    lateinit var productStore: ProductStore

    /**
     * 테스트용 초기 데이터 삽입
     */
    override fun run(vararg args: String?) {
        val userRegisterCommand: UserCommand.UserRegisterCommand = UserCommand.UserRegisterCommand("test-name", 1000, "test-pw");
        val userInfo = userFacade.registerUser(userRegisterCommand)

        val productAddCommand: ProductCommand.ProductAddCommand = ProductCommand.ProductAddCommand("product-name", 1000)
        val product = productStore.storeProduct(productAddCommand.toEntity(user = userInfo.toUserEntity()))
        productStore.storeProduct(product)
    }
}