name := "akka-rest.http-rest-redis"
organization := "dvdancca@gmail.com"
version := "1.0.0"
scalaVersion := "2.12.6"

scalacOptions ++= Seq("-deprecation")

resolvers += Classpaths.sbtPluginReleases

libraryDependencies ++= {
  val akkaHttpV = "10.0.11"
  val scalaTestV = "3.0.4"
  val circeV = "0.9.3"
  val xtractV = "2.0.0"
  val sttpV = "1.1.5"
  val scredisV = "2.1.1"
  val jUnitV = "4.10"
  Seq(
    // Reactive client for Redis
    "com.github.scredis" %% "scredis" % scredisV,

    // HTTP server
    "com.typesafe.akka" %% "akka-http" % akkaHttpV,

    // XML serializer Xtract
    "com.lucidchart" %% "xtract" % xtractV,

    // JSON serialization library
    "io.circe" %% "circe-core" % circeV,
    "io.circe" %% "circe-generic" % circeV,
    "io.circe" %% "circe-parser" % circeV,

    // Sugar for serialization and deserialization in akka-http with circe
    "de.heikoseeberger" %% "akka-http-circe" % "1.19.0",

    // Http client, used currently only for IT test
    //"com.softwaremill.sttp" %% "core" % sttpV % Test,
    //"com.softwaremill.sttp" %% "akka-rest-http-backend" % sttpV % Test,

    // Redis test
    "junit" % "junit" % jUnitV % Test,

    "org.scalatest" %% "scalatest" % scalaTestV % Test,
    "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpV % Test,
    "org.mockito" % "mockito-all" % "1.9.5" % Test
  )
}

addSbtPlugin("com.github.gseitz" % "sbt-release" % "1.0.7")

addSbtPlugin("com.typesafe.sbt" % "sbt-git" % "0.9.3")

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.6")