package com.bdata.emulator.aggregator.cache

import com.bdata.emulator.aggregator.gateway.InfluxGateway
import com.bdata.emulator.aggregator.model.PowerStatus
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.time.OffsetDateTime
import java.util.concurrent.atomic.AtomicReference

@Service
class PowerStatusCache(
    val gateway: InfluxGateway
) {
    val cacheReference = AtomicReference<List<PowerStatus>>()

    @Scheduled(fixedRate = 3000)
    fun updateCache(){
        val queryResult = gateway.getMetricSnapshot("device_power_status")
        val resourceStatusCache = arrayListOf<PowerStatus>()
        for(result in queryResult.results){
            for(series in result.series){
                for(value in series.values){
                    resourceStatusCache.add(
                        PowerStatus(
                            OffsetDateTime.parse(value[0] as String),
                            value[1] as Double,
                            value[2] as String
                        )
                    )
                }
            }
        }
        cacheReference.set(resourceStatusCache)
    }
}