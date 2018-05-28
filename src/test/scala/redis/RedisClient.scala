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

import org.scalatest.AsyncFlatSpec
import scredis.Redis

import scala.concurrent.Future

class RedisClient extends AsyncFlatSpec {

  lazy val redis = Redis()
  import redis.dispatcher

  behavior of "Redis()"

  it should "return pong from Redis Server: standalone mode" in {
    val futureLatest: Future[String] = redis.ping()
    futureLatest map { content => assert(content.equals("PONG")) }
  }

  it should "exists this Redis Set Type with key 'CNN_latest' and is not empty" in {
    val futureLatest: Future[Set[String]] = redis.sMembers("CNN_latest")
    futureLatest map { content => assert(content.nonEmpty) }
  }

  it should "not exists this Redis Set Type with key 'CNN'" in {
    val futureLatest: Future[Set[String]] = redis.sMembers("CNN")
    futureLatest map { content => assert(content.isEmpty) }
  }

  it should "exists this Redis Set Type with key 'CNN_europe' and is not empty" in {
    val futureLatest: Future[Set[String]] = redis.sMembers("CNN_europe")
    futureLatest map { content => assert(content.nonEmpty) }
  }

  it should "exists this Redis Set Type with key 'CNN_sports' and is not empty" in {
    val futureLatest: Future[Set[String]] = redis.sMembers("CNN_sports")
    futureLatest map { content => assert(content.nonEmpty) }
  }

  it should "exists this Redis Set Type with key 'CNN_money' and is not empty" in {
    val futureLatest: Future[Set[String]] = redis.sMembers("CNN_money")
    futureLatest map { content => assert(content.nonEmpty) }
  }

}