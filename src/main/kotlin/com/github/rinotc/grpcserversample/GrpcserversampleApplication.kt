package com.github.rinotc.grpcserversample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GrpcserversampleApplication

fun main(args: Array<String>) {
    runApplication<GrpcserversampleApplication>(*args)
}
