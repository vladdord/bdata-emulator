package com.bdata.emulator.device.pusher.service.status

import java.util.*

enum class DeviceStatus(statusString: String) {
    WORKING("working"),
    STOPPED("stopped"),
    UNAVAILABLE("unavailable"),
    INVALID("invalid");

    companion object {
        fun createStatusList(): List<DeviceStatus> {
            return Collections.unmodifiableList(values().asList())
        }
    }
}