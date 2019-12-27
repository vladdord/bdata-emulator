package com.bdata.emulator.aggregator.gateway

import com.bdata.emulator.aggregator.config.AggregatorConfigs
import org.influxdb.InfluxDB
import org.influxdb.InfluxDBFactory
import org.influxdb.dto.Query
import org.influxdb.dto.QueryResult
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class InfluxGateway(
    val aggregatorConfigs: AggregatorConfigs
) {
    private lateinit var connection: InfluxDB
    private lateinit var databaseName: String

    @PostConstruct
    fun initConnection(){
        connection = InfluxDBFactory.connect(aggregatorConfigs.influxUrl)
        databaseName = aggregatorConfigs.databaseName
    }

    fun getMetricSnapshot(metricName: String): QueryResult{
        return connection.query(Query(
            "select * from $metricName", databaseName
        ))
    }
}