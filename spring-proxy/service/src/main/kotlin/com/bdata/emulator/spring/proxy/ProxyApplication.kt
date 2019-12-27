package com.bdata.emulator.spring.proxy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProxyApplication

fun main(argv: Array<String>){
    runApplication<ProxyApplication>(*argv)
}