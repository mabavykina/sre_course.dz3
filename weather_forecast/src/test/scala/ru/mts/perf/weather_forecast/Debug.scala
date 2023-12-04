package ru.mts.perf.weather_forecast

import io.gatling.http.Predef._
import io.gatling.core.Predef._
import ru.tinkoff.gatling.config.SimulationConfig._
import ru.mts.perf.weather_forecast.scenarios._

class Debug extends Simulation {

  // proxy is required on localhost:8888

  setUp(
    WeatherScenario.scn.inject(atOnceUsers(1)),
  ).protocols(
    httpProtocol,
  ).maxDuration(testDuration)

}
