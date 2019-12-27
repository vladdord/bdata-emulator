package com.bdata.emulator.aggregator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class AggregatorApplication

fun main(argv: Array<String>){
    runApplication<AggregatorApplication>(*argv)
}