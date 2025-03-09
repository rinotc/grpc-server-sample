package com.github.rinotc.grpcserversample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GrpcServerSampleApplication

fun main(args: Array<String>) {
    runApplication<GrpcServerSampleApplication>(*args)
}
