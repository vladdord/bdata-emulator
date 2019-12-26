package com.bdata.emulator.device.pusher.service.worker

import com.bdata.emulator.device.pusher.model.StatusRequest
import com.bdata.emulator.device.pusher.service.status.DeviceStatus
import java.time.OffsetDateTime
import kotlin.random.Random.Default.nextDouble

class Worker {
    fun createStatus(): StatusRequest = run{
        val randomStatus = DeviceStatus.createStatusList().random()
        val time = OffsetDateTime.now()!!
        val resource = nextDouble(0.0, 100.0)
        val powerStatus = nextDouble(0.0, 100.0)
        return StatusRequest(time, powerStatus, resource, randomStatus.name)
    }
}