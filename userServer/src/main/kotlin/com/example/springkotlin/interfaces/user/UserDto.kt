package com.example.springkotlin.interfaces.user

import com.example.springkotlin.domain.product.Product
import com.example.springkotlin.domain.user.UserCommand
import com.example.springkotlin.domain.user.UserInfo

class UserDto {

    class RegisterRequest(
        var userNickName: String,
        var userPassword: String,
        var userCredit: Int
    ) {

        fun toCommand(): UserCommand.UserRegisterCommand {
            return UserCommand.UserRegisterCommand(
                userNickName = userNickName,
                userPassword = userPassword,
                userCredit = userCredit
            )
        }
    }

    class GetWithIdRequest(
        var userId: Long
    )

    class LoginRequest(
        var userNickName: String,
        var userPassword: String
    )

    class UpdateUserCreditRequest(
        val userToken: String,
        val productToken: String,
        val orderToken: String
    )

    class UpdateUserCreditResponse(
        val isUpdated: Boolean,
        val productToken: String,
        val orderToken: String
    )

    class UserLogInResponse(userInfo: UserInfo.Main, jwtToken: String) {
        var jwtToken = jwtToken
        var userToken = userInfo.userToken
        var userId: Long? = userInfo.userId
        var userNickName: String = userInfo.userNickName
        var userPassword: String = userInfo.userPassword
        var userCredit: Int = userInfo.userCredit
        var productSet: MutableSet<Product> = userInfo.userProductSet
    }

    class UserResponse(userInfo: UserInfo.Main) {
        var userToken = userInfo.userToken
        var userId: Long? = userInfo.userId
        var userNickName: String = userInfo.userNickName
        var userPassword: String = userInfo.userPassword
        var userCredit: Int = userInfo.userCredit
        var productSet: MutableSet<Product> = userInfo.userProductSet
    }

}