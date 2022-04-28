package com.example.kafkaserver.interfaces

import com.example.kafkaserver.infrastructures.KafkaProducer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kafka")
class KafkaController {
    @Autowired
    lateinit var producer: KafkaProducer

    @PostMapping
    fun sendMessage(@RequestParam("message") message:String): String {
        this.producer.sendMessage(message)

        return "success"
    }
}