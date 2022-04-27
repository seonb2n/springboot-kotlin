package com.example.kafkaserver.infrastructures

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import java.io.IOException




@Service
class KafkaConsumer {

    @KafkaListener(topics = ["exam"], groupId = "foo")
    @Throws(IOException::class)
    fun consume(message: String?) {
        println(String.format("Consumed message : %s", message))
    }

}