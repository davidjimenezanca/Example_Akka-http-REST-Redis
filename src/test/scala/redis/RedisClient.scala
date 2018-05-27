/*
 * Copyright 2016-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package redis

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import scredis.Redis

import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success}

@RunWith(classOf[JUnitRunner])
class RedisClient extends FunSuite {

  lazy val redis = Redis()
  import redis.dispatcher

  test("Ping to Redis Server: standalone should return pong") {
    val futurePong: Future[String] = redis.ping()
    println("Ping sent!")
    var response = ""
    futurePong.map(pong => {
      println("Redis replied with a " + pong)
    })
    Await.result(futurePong, 2 seconds)
  }

  test("Redis Set Type with key 'CNN_latest' exists and is not empty") {
    val futureLatest: Future[Set[String]] = redis.sMembers("CNN_latest")
    futureLatest onComplete {
      case Success(content) => assert(content.nonEmpty)
      case Failure(e) => fail(s"Empty key 'CNN_latest' or not exists")
    }
    Thread.sleep(2000)
  }

  test("Redis Set Type with key 'CNN_europe' exists and is not empty") {
    val futureEurope: Future[Set[String]] = redis.sMembers("CNN_europe")
    futureEurope onComplete {
      case Success(content) => assert(content.nonEmpty)
      case Failure(e) => fail(s"Empty key 'CNN_europe' or not exists")
    }
    Thread.sleep(2000)
  }

  test("Redis Set Type with key 'CNN_sports' exists and is not empty") {
    val futureSports: Future[Set[String]] = redis.sMembers("CNN_sports")
    futureSports onComplete {
      case Success(content) => assert(content.nonEmpty)
      case Failure(e) => fail(s"Empty key 'CNN_sports' or not exists")
    }
    Thread.sleep(2000)
  }

  test("Redis Set Type with key 'CNN_money' exists and is not empty") {
    val futureMoney: Future[Set[String]] = redis.sMembers("CNN_money")
    futureMoney onComplete {
      case Success(content) => assert(content.nonEmpty)
      case Failure(e) => fail(s"Empty key 'CNN_money' or not exists")
    }
    Thread.sleep(2000)
    redis.quit()
  }

}