package com.bdata.emulator.aggregator.model

import java.time.OffsetDateTime

data class PowerStatus(
    val time: OffsetDateTime,
    val power: Double,
    val status: String
)