package com.example.springkotlin.interfaces.user

import com.example.springkotlin.application.product.ProductFacade
import com.example.springkotlin.application.user.UserFacade
import com.example.springkotlin.interfaces.product.ProductDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/users")
class UserApiController {

    @Autowired
    private lateinit var userFacade: UserFacade

    @Autowired
    private lateinit var productFacade: ProductFacade

    @PostMapping("/getuser")
    fun getUser(@RequestBody getWithIdRequest: UserDto.GetWithIdRequest): UserDto.UserResponse {
        val userInfo = userFacade.getUserWithUserId(getWithIdRequest.userId)
        return UserDto.UserResponse(userInfo)
    }

    @PostMapping("/addProduct")
    fun addProduct(@RequestBody addRequest: ProductDto.AddRequest): ProductDto.ProductResponse {
        val productCommand = addRequest.toCommand()
        val productInfo = productFacade.addProduct(productCommand)
        return ProductDto.ProductResponse(productInfo)
    }

}
