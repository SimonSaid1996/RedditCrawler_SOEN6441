name := """RedditCrawler"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.6"

libraryDependencies += guice

libraryDependencies += "org.json" % "json" % "20210307"

val AkkaVersion = "2.6.14"
libraryDependencies += "com.typesafe.akka" %% "akka-testkit" % AkkaVersion % Test