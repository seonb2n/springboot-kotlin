package com.example.productserver.infrastructures.order

import com.example.productserver.domain.order.OrderCommand
import com.example.productserver.domain.order.OrderInfo
import com.example.productserver.domain.order.service.OrderReader
import com.example.productserver.domain.order.service.OrderService
import com.example.productserver.domain.order.service.OrderStore
import com.example.productserver.domain.order.user.UserApiCaller
import com.example.productserver.domain.order.user.UserApiCommand
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderServiceImpl: OrderService {

    @Autowired
    lateinit var orderStore: OrderStore

    @Autowired
    lateinit var orderReader: OrderReader

    @Autowired
    lateinit var userApiCaller: UserApiCaller

    @Transactional
    override fun registerOrder(orderAddCommand: OrderCommand.OrderRegisterCommand): OrderInfo.Main {
        val jwtToken = orderAddCommand.jwtToken
        var order = orderAddCommand.toEntity()
        order = orderStore.storeOrder(order)
        val userUpdateCommand = UserApiCommand.UpdateUserCredit(order.userToken, order.productToken, order.orderToken)
        userApiCaller.updateUserCredit(jwtToken, userUpdateCommand)
        return OrderInfo.Main(order)
    }

    @Transactional
    override fun updateOrderWithOrderToken(orderToken: String, isUpdated: Boolean) {
        val productOrder = orderReader.getOrderWithOrderToken(orderToken)
        productOrder.isOrderCompleted = isUpdated
    }
}