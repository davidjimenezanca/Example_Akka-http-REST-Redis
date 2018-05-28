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
package rest.service

import model.News
import redis.serializer
import scredis.Redis

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

class ChannelService(implicit executionContext: ExecutionContext) {

  import serializer.XMLStringDeserializer._
  lazy val redis = Redis()
  import redis.dispatcher

  def findAll() : Future[Set[News]] = getAll

  def findByChannel(channel: String): Future[Set[News]] = redis.sMembers(channel)

  def findByTitle(titleToken: String): Future[Set[News]] =
    getAll.map { results => results.collect { case news if news.title.contains(titleToken) => news} }

  def findByLink(linkToken: String): Future[Set[News]] =
    getAll.map { results => results.collect { case news if news.link.contains(linkToken) => news} }


  private def getAll: Future[Set[News]] = {

    val allLatest: Future[Set[News]] = redis.sMembers("CNN_latest")
    allLatest onComplete {
      case Success(content) => content
      case Failure(e) => e
    }
    val allSports: Future[Set[News]] = redis.sMembers("CNN_sports")
    allSports onComplete {
      case Success(content) => content
      case Failure(e) => e
    }
    val allMoney: Future[Set[News]] = redis.sMembers("CNN_money")
    allMoney onComplete {
      case Success(content) => content
      case Failure(e) => e
    }
    val allEurope: Future[Set[News]] = redis.sMembers("CNN_europe")
    allEurope onComplete {
      case Success(content) => content
      case Failure(e) => e
    }

    def squashFutures[News](list: Set[Future[Set[News]]]): Future[Set[News]] =
      Future.sequence(list).map(_.flatten)

    squashFutures(Set(allLatest, allSports, allMoney, allEurope))
  }

}
