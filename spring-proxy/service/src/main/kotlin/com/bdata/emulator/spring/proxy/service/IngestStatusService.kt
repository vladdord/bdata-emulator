package com.bdata.emulator.spring.proxy.service

import com.bdata.emulator.spring.proxy.gateway.InfluxGateway
import com.bdata.emulator.spring.proxy.model.StatusRequest
import org.influxdb.dto.Point
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit

@Service
class IngestStatusService(private val gateway: InfluxGateway) {
    fun ingestData(statusRequest: StatusRequest){
        val pointList = arrayListOf<Point>(
            Point.measurement("device_power_status")
            .addField("power_status", statusRequest.powerStatus)
            .time(statusRequest.time.toEpochSecond(), TimeUnit.NANOSECONDS)
            .tag("status", statusRequest.status)
            .build()
        ) + Point.measurement("device_resource_status")
            .addField("resource_status", statusRequest.resource)
            .time(statusRequest.time.toEpochSecond(), TimeUnit.NANOSECONDS)
            .tag("status", statusRequest.status)
            .build()
        pointList.forEach{
            gateway.pushData(it)
        }
    }
}