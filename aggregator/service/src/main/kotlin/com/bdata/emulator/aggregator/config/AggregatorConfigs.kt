package com.bdata.emulator.aggregator.config

import com.bdata.emulator.aggregator.model.PowerStatus
import com.bdata.emulator.aggregator.model.Resource
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.function.Consumer

@Configuration
@ConfigurationProperties("emulator.aggregator")
class AggregatorConfigs {
    lateinit var influxUrl: String
    lateinit var databaseName: String

    @Bean
    fun createResourceConsumer(): Consumer<Resource> {
        return Consumer { println(it) }
    }

    @Bean
    fun createPowerStatusConsumer(): Consumer<PowerStatus>{
        return Consumer { println(it) }
    }
}