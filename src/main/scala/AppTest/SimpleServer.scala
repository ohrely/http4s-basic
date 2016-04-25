package AppTest

/**
  * Created by rely10 on 4/25/16.
  */

import org.http4s._
import org.http4s.dsl._
import org.http4s.server.blaze.BlazeBuilder

object SimpleService {
  val service = HttpService {
    case GET -> Root =>
      Ok("Hello world.")
  }
}

object SimpleServer {
  def main(args: Array[String]) = BlazeBuilder
    .bindHttp(8080)
    .mountService(SimpleService.service, "/")
    .run
    .awaitShutdown()
}
