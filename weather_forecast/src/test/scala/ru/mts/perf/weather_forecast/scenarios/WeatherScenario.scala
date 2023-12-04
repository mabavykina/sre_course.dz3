package ru.mts.perf.weather_forecast.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import ru.mts.perf.weather_forecast.cases._
import ru.mts.perf.weather_forecast.feeders.Feeders

object WeatherScenario {
  val scn: ScenarioBuilder = scenario("Weather Scenario")
    .feed(Feeders.forecast)
    .feed(Feeders.cities)
    .randomSwitchOrElse(
      70.0 -> exec(Cities.getCityById).exec(Forecast.getForecastById),
      20.0 -> exec(Cities.getCities).exec(Cities.getCityById).exec(Forecast.getForecastById)
    )(
      exec(Forecast.getForecast).exec(Forecast.getForecastById).exec(Cities.getCityById)
    )
}

