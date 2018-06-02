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
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import rest.http.routes.SearchRoutes
import rest.service.ChannelService

import scala.concurrent.{ExecutionContext, Future}

object Boot extends App {

  def startApplication() : Future[Http.ServerBinding] = {

    implicit val actorSystem : ActorSystem = ActorSystem()
    implicit val executor : ExecutionContext = actorSystem.dispatcher
    implicit val materializer : ActorMaterializer = ActorMaterializer()

    val cnnChannelServive = new ChannelService()
    val searchRoutes = new SearchRoutes(cnnChannelServive)

    Http().bindAndHandle(searchRoutes.routeTree, "localhost", 8080)
  }

  startApplication()

}