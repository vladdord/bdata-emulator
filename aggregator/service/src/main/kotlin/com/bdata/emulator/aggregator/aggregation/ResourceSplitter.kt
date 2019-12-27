package com.bdata.emulator.aggregator.aggregation

import com.bdata.emulator.aggregator.model.Resource
import org.springframework.stereotype.Component

@Component
class ResourceSplitter {
    fun split(resourceList: List<Resource>): List<List<Resource>>{
        val statusList = resourceList.map{ it.status }.distinct()
        val splitList = arrayListOf<List<Resource>>()
        for(status in statusList){
            splitList.add(
                resourceList.filter { it.status == status }
            )
        }
        return splitList
    }
}