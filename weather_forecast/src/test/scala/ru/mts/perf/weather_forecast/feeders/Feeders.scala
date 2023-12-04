package ru.mts.perf.weather_forecast.feeders

import io.gatling.core.Predef._

object Feeders {
  val cities = csv("data/cities.csv").circular
  val forecast = csv("data/forecast.csv").circular
}
