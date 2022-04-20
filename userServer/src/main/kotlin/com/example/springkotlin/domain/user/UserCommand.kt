package com.example.springkotlin.domain.user

/**
 * User Data input 을 처리하는 command
 */

class UserCommand {

    class RegisterUser(
        val userNickName: String,
        val userCredit: Int
    ) {
        private fun toEntity(registerUser: RegisterUser): User {
            return User(
                nickName = userNickName,
                credit = userCredit
            )
        }
    }
}