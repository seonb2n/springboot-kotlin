package com.example.springkotlin.infrastructures.kafka

import com.example.springkotlin.interfaces.user.UserDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaProducer {
    val TOPIC: String = "creditUpdate"

    @Autowired
    lateinit var kafkatemplate: KafkaTemplate<String, UserDto.UpdateUserCreditResponse>

    fun sendMessage(updateUserCreditResponse: UserDto.UpdateUserCreditResponse) {
        this.kafkatemplate.send(TOPIC, updateUserCreditResponse)
    }
}