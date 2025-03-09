package com.github.rinotc.grpcserversample.grpc.services

import com.github.rinotc.protobuf.HelloRequest
import com.github.rinotc.protobuf.HelloResponse
import com.github.rinotc.protobuf.SimpleGrpc
import io.grpc.stub.StreamObserver
import org.apache.commons.logging.LogFactory
import org.springframework.stereotype.Service

@Service
class SimpleService : SimpleGrpc.SimpleImplBase() {

    override fun sayHello(request: HelloRequest, responseObserver: StreamObserver<HelloResponse>) {
        logger.info("Hello ${request.name}")
        if (request.name.startsWith("error")) {
            throw IllegalArgumentException("Bad name: ${request.name}")
        }
        if (request.name.startsWith("internal")) {
            throw RuntimeException("Internal error")
        }
        val response = HelloResponse.newBuilder().setMessage("Hello ==> ${request.name}").build()
        responseObserver.onNext(response)
        responseObserver.onCompleted()
    }

    companion object {
        private val logger = LogFactory.getLog(SimpleService::class.java)
    }
}