package ru.mts.perf.weather_forecast.cases

import io.gatling.http.Predef._
import io.gatling.core.Predef._

object Forecast {

  val getForecast = http("GET /Forecast")
    .get("/Forecast")

  val getForecastById = http("GET /Forecast/{id}")
    .get("/Forecast/#{forecastId}")

}