package com.example.springkotlin.config.kafka

import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.kafka.support.serializer.JsonSerializer


class CommonJsonSerializer {

    companion object {
        fun getStringObjectMap(bootstrapServer: String): Map<String, Any> {

            val props: MutableMap<String, Any> = HashMap()
            props[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapServer
            props[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
            props[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = JsonSerializer::class.java

            return props
        }
    }

}
