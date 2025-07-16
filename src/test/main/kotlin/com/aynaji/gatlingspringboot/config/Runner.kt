package com.aynaji.gatlingspringboot.config

import com.aynaji.gatlingspringboot.simulation.MySimulation
import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class Runner : CommandLineRunner {
    override fun run(vararg args: String?) {

        println("*** Simulation Started ***")

        val props = GatlingPropertiesBuilder()
            .simulationClass(MySimulation::class.java.canonicalName)

        Gatling.fromMap(props.build())

        println("*** Simulation ended ***")
    }
}