package com.bdata.emulator.spring.proxy.gateway

import com.bdata.emulator.spring.proxy.config.ProxyConfig
import org.influxdb.InfluxDB
import org.influxdb.InfluxDBFactory
import org.influxdb.dto.Point
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class InfluxGateway(private val proxyConfig: ProxyConfig) {
    private lateinit var influxDb: InfluxDB
    private var udpPort = 0

    @PostConstruct
    private fun initConnection(){
        influxDb = InfluxDBFactory.connect(proxyConfig.influxDbUrl)
        udpPort = proxyConfig.influxDbUdpPort
    }

    fun pushData(dataPoint: Point){
        influxDb.write(udpPort, dataPoint)
    }
}