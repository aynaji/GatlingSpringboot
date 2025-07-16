package com.aynaji.gatlingspringboot.simulation

import io.gatling.javaapi.core.CoreDsl
import io.gatling.javaapi.core.Simulation
import io.gatling.javaapi.http.HttpDsl

class MySimulation : Simulation() {

    val httpProtocol = HttpDsl.http
        .baseUrl("http://localhost:8081") // replace with your actual base URL
        .acceptHeader("application/json")

    val postRequest = CoreDsl.exec(
        HttpDsl.http("Post Request")
            .post("/post-endpoint") // replace with your actual POST endpoint
    )

    val getRequest = CoreDsl.exec(
        HttpDsl.http("Get Request")
            .get("/get-endpoint") // replace with your actual GET endpoint
    )

    val scn = CoreDsl.scenario("PostThenGetScenario").exec(postRequest)
    init {
        setUp(scn.injectOpen(CoreDsl.atOnceUsers(1))).protocols(httpProtocol)
    }
}