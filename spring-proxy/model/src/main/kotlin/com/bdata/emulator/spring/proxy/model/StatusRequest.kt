package com.bdata.emulator.spring.proxy.model

import java.time.OffsetDateTime

data class StatusRequest(
    val time: OffsetDateTime,
    val powerStatus: Double,
    val resource: Double,
    val status: String
)