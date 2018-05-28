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
package rest.http.routes

import akka.http.scaladsl.server.Directives.{complete, get, pathEndOrSingleSlash, pathPrefix}
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport
import rest.service.ChannelService

import scala.concurrent.ExecutionContext
import scala.util.{Failure, Success}

class SearchRoutes(
                    channelService: ChannelService
                  )(implicit executionContext: ExecutionContext) extends FailFastCirceSupport {

  import channelService._

  val route = pathPrefix("rest-cnn-news/search") {
    pathPrefix("getAll") {
      pathEndOrSingleSlash {
        get {
            complete(findAll onComplete {
              case Success(content) => content
              case Failure(ex) => "An error occurs -> " + ex.getStackTrace
            })
        }
      }
    }
  }

}