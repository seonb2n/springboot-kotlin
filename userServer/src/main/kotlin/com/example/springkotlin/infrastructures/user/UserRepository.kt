package com.example.springkotlin.infrastructures.user

import com.example.springkotlin.domain.user.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
    fun getUserByUserId(userId: Long) : User?
    fun getUserByNickName(userNickName: String) : User?
}