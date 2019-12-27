package com.bdata.emulator.aggregator.model

import java.time.OffsetDateTime

data class Resource(
    val time: OffsetDateTime,
    val resource: Double,
    val status: String
)