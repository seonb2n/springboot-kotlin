package com.example.springkotlin.domain.user.service

import com.example.springkotlin.domain.product.service.ProductReader
import com.example.springkotlin.domain.user.UserCommand
import com.example.springkotlin.domain.user.UserInfo
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Slf4j
class UserServiceImpl : UserService {

    @Autowired
    lateinit var userReader: UserReader

    @Autowired
    lateinit var userStore: UserStore

    @Autowired
    lateinit var productReader: ProductReader

    @Transactional
    override fun registerUser(registerUser: UserCommand.UserRegisterCommand): UserInfo.Main {
        val initUser = registerUser.toEntity()
        val user = userStore.storeUser(initUser)
        return UserInfo.Main(user)
    }

    override fun getUserWithUserId(userId: Long): UserInfo.Main {
        val user = userReader.getUserWithUserId(userId)
        return UserInfo.Main(user)
    }

    override fun getUserWithUserNickName(userNickName: String): UserInfo.Main {
        val user = userReader.getUserWithUserNickName(userNickName)
        return UserInfo.Main(user)
    }

    override fun loadUserByUsername(username: String): UserDetails {
        return userReader.getUserWithUserNickName(username)
    }

    override fun isUserExist(userNickName: String): Boolean {
        return userReader.isUserExist(userNickName)
    }

    @Transactional
    override fun updateUserCredit(userToken: String, productToken: String): Boolean {
        //request 의 userToken 으로 user 를 불러온다.
        //request 의 productToken 으로 product 소유주를 불러온다.
        //credit 을 교환한다.
        //product 의 소유권을 변경한다.

        val buyUser = userReader.getUserWithUserToken(userToken)
        val product = productReader.getProductWithProductToken(productToken)
        val sellUser = product.user
        val productCost = product.cost
        if (buyUser.credit >= productCost) {
            buyUser.credit -= productCost
            sellUser.credit += productCost
            product.user = buyUser
            return true
        }
        return false
    }
}