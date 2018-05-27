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

import model.News
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import scredis.Redis

import scala.concurrent.Future
import scala.util.{Failure, Success}

@RunWith(classOf[JUnitRunner])
class Serialization extends FunSuite {

  import serializer.XMLStringDeserializer._
  lazy val redis = Redis()
  import redis.dispatcher

  test("Serialization of values in Redis-Sets to News case class") {
    val futureLatest: Future[Set[News]] = redis.sMembers("CNN_latest")
    futureLatest onComplete {
      case Success(content) => assert(content.head.isInstanceOf[News])
      case Failure(e) => fail(s"Empty key 'CNN_latest' or not exists")
    }
    Thread.sleep(2000)
    redis.quit()
  }

}
