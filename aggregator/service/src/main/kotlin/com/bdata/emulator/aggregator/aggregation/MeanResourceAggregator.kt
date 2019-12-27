package com.bdata.emulator.aggregator.aggregation

import com.bdata.emulator.aggregator.cache.ResourceCache
import com.bdata.emulator.aggregator.model.Resource
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.Instant
import java.time.OffsetDateTime
import java.util.*
import java.util.function.Consumer

@Component
class MeanResourceAggregator(
    val resourceCache: ResourceCache,
    val resourceSplitter: ResourceSplitter,
    val resourceConsumer: Consumer<Resource>
) {

    @Scheduled(fixedRate = 3000)
    fun calcMeanResource(){
        GlobalScope.launch {
            for(block in resourceSplitter.split(resourceCache.cacheReference.get())){
                val meanTime: Long = (block.first().time.toEpochSecond() + block.last().time.toEpochSecond()) / 2
                var value = 0.0
                block.forEach{
                    value += it.resource
                }
                resourceConsumer.accept(Resource(
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