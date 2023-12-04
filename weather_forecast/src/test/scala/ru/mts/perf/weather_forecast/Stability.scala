package ru.mts.perf.weather_forecast

import io.gatling.core.Predef._
import ru.tinkoff.gatling.config.SimulationConfig._
import ru.tinkoff.gatling.influxdb.Annotations
import ru.mts.perf.weather_forecast.scenarios._

class Stability extends Simulation with Annotations {

  setUp(
    WeatherScenario.scn.inject(
      // разгон
      rampUsersPerSec(0) to intensity.toInt during rampDuration,
      // полка
      constantUsersPerSec(intensity.toInt) during stageDuration,
    ),
  ).protocols(
    httpProtocol,
    // длительность теста = разгон + полка
  ).maxDuration(testDuration)

}
