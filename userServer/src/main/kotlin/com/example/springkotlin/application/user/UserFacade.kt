package com.example.springkotlin.application.user

import com.example.springkotlin.domain.user.UserCommand
import com.example.springkotlin.domain.user.UserInfo
import com.example.springkotlin.domain.user.service.UserService
import com.example.springkotlin.infrastructures.kafka.KafkaProducer
import com.example.springkotlin.interfaces.user.UserDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserFacade {

    @Autowired
    lateinit var userService: UserService

    @Autowired
    private lateinit var kafkaProducer: KafkaProducer

    fun registerUser(registerUser: UserCommand.UserRegisterCommand): UserInfo.Main {
        return userService.registerUser(registerUser)
    }

    fun getUserWithUserId(userId: Long): UserInfo.Main {
        return userService.getUserWithUserId(userId)
    }

    fun getUserWithUserNickName(userNickName: String): UserInfo.Main {
        return userService.getUserWithUserNickName(userNickName)
    }

    fun isUserExist(userNickName: String): Boolean {
        return userService.isUserExist(userNickName)
    }

    fun updateUserCredit(userToken: String, productToken: String, orderToken: String) {
        val updateResult = userService.updateUserCredit(userToken, productToken)
        val response = UserDto.UpdateUserCreditResponse(updateResult, productToken, orderToken)
        kafkaProducer.sendMessage(response)
    }

}