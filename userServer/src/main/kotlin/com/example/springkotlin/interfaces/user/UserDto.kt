package com.example.springkotlin.interfaces.user

import com.example.springkotlin.domain.product.Product
import com.example.springkotlin.domain.user.UserCommand

class UserDto {

    class RegisterRequest (
        var userNickName: String,
        var userCredit: Int
            ){

        fun toCommand(): UserCommand.RegisterUser {
            return UserCommand.RegisterUser(
                userNickName = userNickName,
                userCredit = userCredit
            )
        }
    }

    class GetWithIdRequest(
        var userId: Long
    )

    class UserResponse(
        var userId: Long?,
        var userNickName: String,
        var userCredit: Int,
        var productSet: MutableSet<Product>
    ) {
    }

}