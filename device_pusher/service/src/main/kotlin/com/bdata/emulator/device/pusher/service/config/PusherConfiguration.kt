package com.bdata.emulator.device.pusher.service.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.Duration

@Configuration
@ConfigurationProperties("bdata.emulator.device-pusher")
class PusherConfiguration {
    lateinit var serverUrl: String
    var workerCount: Int = 0
    lateinit var pushTimeout: Duration

    @Bean
    fun createMapper(): ObjectMapper {
        return ObjectMapper()
            .registerKotlinModule()
            .registerModule(JavaTimeModule())
    }
}