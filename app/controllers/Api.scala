package controllers

import play.api._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
class Api extends Controller {

  /**
   * Conventional API
   */
  def index = Action {
     Ok("Let's go")
  }

}
