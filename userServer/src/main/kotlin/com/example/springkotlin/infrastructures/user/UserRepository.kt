package com.example.springkotlin.infrastructures.user

import com.example.springkotlin.domain.user.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
    fun findUserByUserId(userId: Long) : User?
    fun findUserByNickName(userNickName: String) : User?
    fun findUserByUserToken(userToken: String) : User?
}