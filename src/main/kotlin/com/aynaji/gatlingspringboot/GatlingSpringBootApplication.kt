package com.aynaji.gatlingspringboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GatlingSpringBootApplication

fun main(args: Array<String>) {
    runApplication<GatlingSpringBootApplication>(*args)
}
