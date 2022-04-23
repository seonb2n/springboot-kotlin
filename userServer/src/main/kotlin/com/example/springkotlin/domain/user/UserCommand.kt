package com.example.springkotlin.domain.user

import com.example.springkotlin.common.UserRole

/**
 * User Data input 을 처리하는 command
 */

class UserCommand {

    class RegisterUser(
        val userNickName: String,
        val userCredit: Int,
        val userPassword: String
    ) {
        fun toEntity(): User {
            return User(
                nickName = userNickName,
                credit = userCredit,
                m_password = userPassword
            )
        }

    }
}