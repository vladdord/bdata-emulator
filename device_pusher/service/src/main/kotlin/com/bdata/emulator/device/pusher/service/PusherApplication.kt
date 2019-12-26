package com.bdata.emulator.device.pusher.service

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class PusherApplication

fun main(argv: Array<String>){
    runApplication<PusherApplication>(*argv)
}
