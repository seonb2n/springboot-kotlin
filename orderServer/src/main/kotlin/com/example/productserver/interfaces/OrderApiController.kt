package com.example.productserver.interfaces

import com.example.productserver.application.OrderFacade
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/order")
class OrderApiController {

    @Autowired
    lateinit var orderFacade: OrderFacade

    @PostMapping("/register")
    fun registerOrder(@RequestBody orderRegisterRequest: OrderDto.RegisterRequest): OrderDto.RegisterResponse {
        val registerCommand = orderRegisterRequest.toCommand()
        val registerInfo = orderFacade.registerOrder(registerCommand)
        return OrderDto.RegisterResponse(registerInfo)
    }
}