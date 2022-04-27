package com.example.springkotlin.config.kafka

import com.example.springkotlin.interfaces.user.UserDto
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory

@Configuration
class CreditUpdateProducerConfig {

    @Value("\${spring.kafka.producer.bootstrap-servers}")
    lateinit var bootstrapServer: String

    @Bean
    fun creditUpdateConfigs(): Map<String, Any> {
        return CommonJsonSerializer.getStringObjectMap(bootstrapServer)
    }

    @Bean
    fun creditUpdateDTOProducerFactory(): ProducerFactory<String, UserDto.UpdateUserCreditResponse> {
        return DefaultKafkaProducerFactory(creditUpdateConfigs())
    }

    @Bean
    fun creditUpdateDTOKafkaTemplate(): KafkaTemplate<String, UserDto.UpdateUserCreditResponse> {
        return KafkaTemplate(creditUpdateDTOProducerFactory())
    }
}