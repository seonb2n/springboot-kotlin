package com.example.springkotlin.infrastructures.user

import com.example.springkotlin.domain.user.User
import com.example.springkotlin.domain.user.service.UserReader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.lang.RuntimeException

@Component
class UserReaderImpl : UserReader{

    @Autowired
    lateinit var userRepository: UserRepository

    override fun getUserWithUserId(userId: Long): User {
        return userRepository.findUserByUserId(userId) ?: throw RuntimeException("$userId can not found")
    }

    override fun getUserWithUserNickName(userNickName: String): User {
        return userRepository.findUserByNickName(userNickName) ?: throw RuntimeException("$userNickName can not found")
    }

    override fun isUserExist(userNickName: String): Boolean {
        if(userRepository.findUserByNickName(userNickName) == null) {
            return false
        }
        return true
    }

    override fun getUserWithUserToken(userToken: String): User {
        return userRepository.findUserByUserToken(userToken) ?: throw RuntimeException("$userToken can not found")
    }
}