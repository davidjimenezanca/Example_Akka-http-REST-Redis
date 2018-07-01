name := "akka-rest-http-rest-redis"
organization := "dvdancca@gmail.com"
version := "1.0.0"
scalaVersion := "2.12.6"

scalacOptions ++= Seq("-deprecation")

resolvers += "jitpack" at "https://jitpack.io"

libraryDependencies ++= {
  val akkaHttpV = "10.0.1"
  val akkaActorV = "2.4.12"
  val akkaStreamsV = "2.4.12"
  val akkaCirceV = "1.19.0"
  val scalaTestV = "3.0.4"
  val xtractV = "2.0.0"
  val circeV = "0.9.3"
  val logV = "1.1.3"
  Seq(
    // Reactive client for Redis
    "com.github.scredis" %% "scredis" % "dd45255a1f2034a72fc8522bc407fc4b6f2d6ad9",

    // HTTP server
    "com.typesafe.akka" %% "akka-http" % akkaHttpV,
    "com.typesafe.akka" %% "akka-actor" % akkaActorV,
    "com.typesafe.akka" %% "akka-stream" % akkaStreamsV,
    "ch.qos.logback" % "logback-classic" % logV % Runtime,

    // XML serializer Xtract
    "com.lucidchart" %% "xtract" % xtractV,

    // JSON serialization library
    "io.circe" %% "circe-core" % circeV,
    "io.circe" %% "circe-generic" % circeV,
    "io.circe" %% "circe-parser" % circeV,

    // Sugar for serialization and deserialization in akka-http with circe
    "de.heikoseeberger" %% "akka-http-circe" % akkaCirceV,

    // Scala Test
    "org.scalatest" %% "scalatest" % scalaTestV % Test
  )

}