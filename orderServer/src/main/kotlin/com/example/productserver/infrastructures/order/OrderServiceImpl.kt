package com.example.productserver.infrastructures.order

import com.example.productserver.domain.order.OrderCommand
import com.example.productserver.domain.order.OrderInfo
import com.example.productserver.domain.order.service.OrderService
import com.example.productserver.domain.order.service.OrderStore
import com.example.productserver.domain.order.user.UserApiCaller
import com.example.productserver.domain.order.user.UserApiCommand
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrderServiceImpl: OrderService {

    @Autowired
    lateinit var orderStore: OrderStore

    @Autowired
    lateinit var userApiCaller: UserApiCaller

    override fun registerOrder(orderRegisterCommand: OrderCommand.OrderRegisterCommand): OrderInfo.Main {
        val jwtToken = orderRegisterCommand.jwtToken
        var order = orderRegisterCommand.toEntity()
        val userUpdateCommand = UserApiCommand.UpdateUserCredit(order.userToken, order.productToken)
        if(userApiCaller.updateUserCredit(jwtToken, userUpdateCommand)) {
            order.isOrderCompleted = true
        }
        order = orderStore.storeOrder(order)
        return OrderInfo.Main(order)
    }
}