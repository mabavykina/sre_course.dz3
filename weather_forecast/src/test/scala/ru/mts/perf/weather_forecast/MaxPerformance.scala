package ru.mts.perf.weather_forecast

import io.gatling.core.Predef._
import ru.tinkoff.gatling.config.SimulationConfig._
import ru.tinkoff.gatling.influxdb.Annotations
import ru.mts.perf.weather_forecast.scenarios._
import scala.concurrent.duration._

class MaxPerformance extends Simulation with Annotations {

  setUp(
    WeatherScenario.scn.inject(
      rampUsersPerSec(0) to 135 during(15 minutes),
      constantUsersPerSec(135) during(30 minutes)
    ),
  ).protocols(
    httpProtocol,
    // общая длительность теста
  ).maxDuration(45 minutes)

}
