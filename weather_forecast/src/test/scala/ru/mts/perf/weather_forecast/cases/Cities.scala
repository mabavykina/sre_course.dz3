package ru.mts.perf.weather_forecast.cases

import io.gatling.http.Predef._
import io.gatling.core.Predef._

object Cities {

  val getCities = http("GET /Cities")
    .get("/Cities")

  val getCityById = http("GET /Cities/{id}")
    .get("/Cities/#{cityId}")
}
