package com.example.kafkaserver.infrastructures

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaProducer {
    val TOPIC: String = "exam"

    @Autowired
    lateinit var kafkaTemplate: KafkaTemplate<String, String>

    fun sendMessage(message: String) {
        println(String.format("Produce Message: %s", String))
        this.kafkaTemplate.send(TOPIC, message)
    }

}