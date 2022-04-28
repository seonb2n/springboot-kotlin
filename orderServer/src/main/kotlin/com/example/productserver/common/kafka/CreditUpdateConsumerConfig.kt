package com.example.productserver.common.kafka

import com.example.productserver.infrastructures.user.CreditUpdateDtoResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.converter.StringJsonMessageConverter

@Configuration
class CreditUpdateConsumerConfig {

    @Value("\${spring.kafka.consumer.bootstrap-servers}")
    lateinit var bootstrapServer: String

    @Bean
    fun creditUpdateConsumerConfigs(): Map<String, Any> {
        return CommonJsonDeserializer.getStringObjectMap(bootstrapServer)
    }

    @Bean
    fun creditUpdateDTO_ConsumnerFactory(): ConsumerFactory<String, CreditUpdateDtoResponse.Update> {
        return DefaultKafkaConsumerFactory(creditUpdateConsumerConfigs())
    }

    @Bean
    fun creditUpdateListener(): ConcurrentKafkaListenerContainerFactory<String, CreditUpdateDtoResponse.Update> {
        val factory: ConcurrentKafkaListenerContainerFactory<String, CreditUpdateDtoResponse.Update> = ConcurrentKafkaListenerContainerFactory()
        factory.consumerFactory = creditUpdateDTO_ConsumnerFactory()
        return factory
    }

    @Bean
    fun jsonConverter(): StringJsonMessageConverter {
        return StringJsonMessageConverter()
    }

}