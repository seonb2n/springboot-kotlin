package com.example.springkotlin.infrastructure.user

import com.example.springkotlin.domain.user.User
import com.example.springkotlin.domain.user.service.UserReader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component

@Component
class UserReaderImpl : UserReader{

    @Autowired
    lateinit var userRepository: UserRepository

    override fun getUserWithUserId(userId: Long): User {
        //todo 에러 처리 로직 필요
        return userRepository.getUserByUserId(userId) ?: throw UsernameNotFoundException("$userId can not found")
    }

    override fun getUserWithUserNickName(userNickName: String): User {
        return userRepository.getUserByNickName(userNickName) ?: throw UsernameNotFoundException("$userNickName can not found")
    }
}