name := "akka-rest-http-rest-redis"
organization := "dvdancca@gmail.com"
version := "1.0.0"
scalaVersion := "2.12.6"

scalacOptions ++= Seq("-deprecation")

libraryDependencies ++= {
  val akkaHttpV = "10.1.1"
  val akkaActorV = "2.5.12"
  val akkaStreamsV = "2.5.12"
  val akkaCirceV = "1.19.0"
  val scalaTestV = "3.0.4"
  val scredisV = "2.1.1"
  val xtractV = "2.0.0"
  val circeV = "0.9.3"
  val logV = "1.1.3"
  Seq(
    // Reactive client for Redis
    "com.github.scredis" %% "scredis" % scredisV,

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