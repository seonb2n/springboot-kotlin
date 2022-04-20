package com.example.springkotlin.domain.user.service

import com.example.springkotlin.domain.user.UserCommand
import com.example.springkotlin.domain.user.UserInfo
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Slf4j
class UserServiceImpl : UserService{

    @Autowired
    lateinit var userReader: UserReader

    @Autowired
    lateinit var userStore: UserStore

    @Transactional
    override fun registerUser(registerUser: UserCommand.RegisterUser): UserInfo.Main {
        val initUser = registerUser.toEntity()
        val user = userStore.storeUser(initUser)
        return UserInfo.Main(user)
    }

    @Transactional
    override fun getUserWithUserId(userId: Long): UserInfo.Main {
        val user = userReader.getUserWithUserId(userId)
        return UserInfo.Main(user)
    }
}