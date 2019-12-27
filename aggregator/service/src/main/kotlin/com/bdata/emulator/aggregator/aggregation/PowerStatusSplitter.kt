package com.bdata.emulator.aggregator.aggregation

import com.bdata.emulator.aggregator.model.PowerStatus
import org.springframework.stereotype.Component

@Component
class PowerStatusSplitter {
    fun split(powerStatusList: List<PowerStatus>): List<List<PowerStatus>>{
        val statusList = powerStatusList.map{ it.status }.distinct()
        val splitList = arrayListOf<List<PowerStatus>>()
        for(status in statusList){
            splitList.add(
                powerStatusList.filter { it.status == status }
            )
        }
        return splitList
    }
}