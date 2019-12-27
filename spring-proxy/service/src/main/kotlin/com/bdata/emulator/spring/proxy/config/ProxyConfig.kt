package com.bdata.emulator.spring.proxy.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties("spring-proxy.service")
class ProxyConfig {
    lateinit var influxDbUrl: String
    var influxDbUdpPort: Int = 0
}