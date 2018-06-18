# Akka Http server and REST API for CNN news channels

Example project of Scala Akka-http server and client with Redis database.

REST services are built with Akka Actor paradigm and it works with Redis client scredis for Scala.

# REST

REST has quickly become the de-facto standard for building web services on the web because they’re easy to build and easy to consume.

There’s a much larger discussion to be had about how REST fits in the world of microservices. Akka HTTP has been driven with a clear focus on providing tools for building integration layers rather than application cores. As such it regards itself as a suite of libraries rather than a framework

# AKKA HTTP

Akka HTTP is provided as independent modules from Akka itself under its own release cycle.

The high-level, routing API of Akka HTTP provides a DSL to describe HTTP “routes” and how they should be handled. Each route is composed of one or more level of Directive s that narrows down to handling one specific type of request.

# xtract LIBRARY

Xtract is a scala library for deserializing XML. It is heavily inspired by the combinators in the Cats library. This library, developed by Lucidchart team, allows you:

- Easily define how XML should be parsed into a class, ideally with declarative syntax
- Perform validation and transformations on the input XML before storing in the class
- Easily recover from errors, but keep information about the errors so we can inform users what went wrong and investigate it


- [Cats](https://github.com/typelevel/cats)
- [Lucidchart](https://lucidchart.com)

# Redis

Redis is an open source (BSD licensed), in-memory data structure store, used as a database, cache and message broker. It supports data structures such as strings, hashes, lists, sets, sorted sets with range queries, bitmaps, hyperloglogs and geospatial indexes with radius queries. 

Redis has built-in replication, Lua scripting, LRU eviction, transactions and different levels of on-disk persistence, and provides high availability via Redis Sentinel and automatic partitioning with Redis Cluster.

### Server

In this example we use Redis as a sever database in standalone mode.

### Scala scredis Client

SCREDIS is a Non-blocking, ultra-fast Scala Redis client built on top of Akka IO, used in production at Livestream.

In this example we work with two ActorSystems: one for Akka server and another one for DB client, but you can change this 'antipattern' and implement a single ActorSystem with use of Akka dispatchers as this client is fully configurable.

## Prerequisites

You will need following to run this application:

- [Redis 4+](https://redis.io/download)
- [Java 8+](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
- [Scala 2.12+](https://www.scala-lang.org/download/)
- [SBT 1+](https://www.scala-sbt.org/download.html)

NOTE ABOUT DATA MODEL: As data model is replicated from following Redis GitHub project: 

- [Spring Data for Redis](https://github.com/davidjimenezanca/Example_Spring-Data-Redis)

To work with this example you will need to run the previous project in order to store data sets at Redis server.

## Starting the application

As first step you will need to install and start a Redis DB.

Second you will need to store the Sets keys in Redis with the model mentioned in previous section.

For each Set key, the value is stored in XML-string format.

In this project client's DB configuration is done for a running local Redis server.

After local database requirements are done you can start this application using SBT: just typing:

 sbt run

REST UI application is available at:

 http://localhost:8080

In the following "swagger.json" file you could find a complete doc about REST API

A link to this file is available at Gist: https://gist.github.com/davidjimenezanca/396cbff61bc0f9eb94a3227f46d93554

# See Also

- [AKKA](https://akka.io/)
- [Scala API](https://www.scala-lang.org/api/2.12.0-RC1/index.html)
- [Redis](https://redis.io)
- [scredis client](https://github.com/scredis/scredis)
- [xtract library](https://github.com/lucidsoftware/xtract)

# Author

- David Jiménez Anca : https://twitter.com/davidjimenezanc
- mailto: dvdancca@gmail.com
- Upwork profile: https://www.upwork.com/fl/davidjimenez3


