package com.example.springkotlin.domain.user

import com.example.springkotlin.domain.product.Product

/**
 * User Data output 을 처리하는 command
 */

class UserInfo {

    class Main(user: User) {
        val userToken: String = user.userToken
        val userId: Long? = user.userId
        val userNickName: String = user.nickName
        val userCredit: Int = user.credit
        val userProductSet: MutableSet<Product> = user.productSet
        val userPassword: String = user.userPassword

        fun toUserEntity(): User {
            return User(userToken, userId, userToken, userNickName, userPassword, userCredit, userProductSet)
        }
    }
}