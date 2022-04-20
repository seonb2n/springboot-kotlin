package com.example.springkotlin.domain.user

import com.example.springkotlin.domain.product.Product

/**
 * User Data output 을 처리하는 command
 */

class UserInfo {

    class Main(
        var userId: Long?,
        var userNickName: String,
        var userCredit: Int,
        var userProductSet: MutableSet<Product>
    ) {
        fun toMain(user: User) :Main {
            return Main(
                userId = user.userId,
                userNickName = user.nickName,
                userCredit = user.credit,
                userProductSet = user.productSet
            )
        }
    }
}