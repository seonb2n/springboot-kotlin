package com.example.springkotlin.domain.user

/**
 * User Data input 을 처리하는 command
 */

class UserCommand {

    class UserRegisterCommand(
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