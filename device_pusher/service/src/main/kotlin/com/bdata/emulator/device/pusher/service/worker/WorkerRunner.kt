package com.bdata.emulator.device.pusher.service.worker

import com.bdata.emulator.device.pusher.service.config.PusherConfiguration
import com.fasterxml.jackson.databind.ObjectMapper
import io.github.rybalkinsd.kohttp.dsl.async.httpPostAsync
import io.github.rybalkinsd.kohttp.ext.url
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class WorkerRunner(
    val pusherConfiguration: PusherConfiguration,
    val mapper: ObjectMapper
) {
    @Suppress("BlockingMethodInNonBlockingContext", "DeferredResultUnused")
    @Scheduled(fixedRateString = "#{pusherConfiguration.pushTimeout}")
    fun pushStatus(){
        for(index in 1..pusherConfiguration.workerCount){
            GlobalScope.launch {
                val worker = Worker()
                val serializedStatus =  mapper.writeValueAsString(worker.createStatus())!!
                httpPostAsync {
                    url(pusherConfiguration.serverUrl)
                    header {
                        "Content-Type" to "application/json"
                    }
                    body {
                        string(serializedStatus)
                    }
                }
            }
        }
    }
}