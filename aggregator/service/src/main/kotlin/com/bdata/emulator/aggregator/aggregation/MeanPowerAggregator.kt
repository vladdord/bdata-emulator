package com.bdata.emulator.aggregator.aggregation

import com.bdata.emulator.aggregator.cache.PowerStatusCache
import com.bdata.emulator.aggregator.model.PowerStatus
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.Instant
import java.time.OffsetDateTime
import java.util.*
import java.util.function.Consumer

@Component
class MeanPowerAggregator(
    val powerStatusCache: PowerStatusCache,
    val powerStatusSplitter: PowerStatusSplitter,
    val powerStatusConsumer: Consumer<PowerStatus>
) {
    @Scheduled(fixedRate = 3000)
    fun aggregatePowerStatus(){
        GlobalScope.launch {
            for(block in powerStatusSplitter.split(powerStatusCache.cacheReference.get())){
                val meanTime: Long = (block.first().time.toEpochSecond() + block.last().time.toEpochSecond()) / 2
                var value = 0.0
                block.forEach{
                    value += it.power
                }
                powerStatusConsumer.accept(
                    PowerStatus(
                        OffsetDateTime.ofInstant(
                            Instant.ofEpochSecond(meanTime),
                            TimeZone.getDefault().toZoneId()
                        ),
                        value / block.size,
                        block.first().status)
                )
            }
        }
    }
}