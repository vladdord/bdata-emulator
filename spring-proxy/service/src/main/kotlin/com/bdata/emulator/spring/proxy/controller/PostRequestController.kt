package com.bdata.emulator.spring.proxy.controller

import com.bdata.emulator.spring.proxy.model.StatusRequest
import com.bdata.emulator.spring.proxy.service.IngestStatusService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class PostRequestController(private val ingestStatusService: IngestStatusService) {

    @PostMapping("/status")
    @ResponseBody
    fun ingestStatus(@RequestBody statusRequest: StatusRequest){
        ingestStatusService.ingestData(statusRequest)
    }
}