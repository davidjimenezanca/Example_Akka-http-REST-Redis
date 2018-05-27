package rest.http.routes

import akka.http.scaladsl.server.Directives.{complete, get, pathEndOrSingleSlash, pathPrefix}
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport
import rest.service.ChannelService

import scala.concurrent.ExecutionContext

class SearchRoutes(
                    channelService: ChannelService
                  )(implicit executionContext: ExecutionContext) extends FailFastCirceSupport {

  import channelService._

  val route = pathPrefix("rest-cnn-news/search") {
    pathPrefix("getAll") {
      pathEndOrSingleSlash {
        get {
          complete("Ok")
        }
      }
    }
  }

}
