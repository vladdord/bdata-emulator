package com.bdata.emulator.device.pusher.model

import java.time.OffsetDateTime

data class StatusRequest(
    val time: OffsetDateTime,
    val powerStatus: Double,
    val resource: Double,
    val status: String
)