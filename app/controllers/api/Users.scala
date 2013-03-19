package controllers.api

import play.api.mvc.{Action, Controller}
import play.api.libs.json._
import models.{User}
import play.api.libs.json.Writes._
import Json._
import controllers.Conversions._
import data.{UserDao}
import data.Implicits._
import play.Logger

/**
 * JSON service for providing information about User
 */
object Users extends Controller {

  trait UserWrites extends Writes[User] {
    def writes(value: User) = JsObject(Seq(
      "id"        -> toJson(value.id),
      "firstName" -> toJson(value.firstName),
      "lastName"  -> toJson(value.lastName),
      "gender"    -> toJson(value.gender)
      ))
  }

  implicit object UserWrites extends UserWrites

  def all() = Action { implicit request =>
      val users = UserDao.findAll()
      val json = Json.toJson(users)
      Ok(json)
  }

  /**
   * Example of secured method with HTTP basic authentication
   */
  def detail(userId: String) = Action { implicit request =>
      val userOpt = UserDao.findOneById(userId)
      userOpt.map { user =>
          val json =Json.toJson(user)
          Ok(json)
      }.getOrElse(NotFound("User not found with: " + userId))
  }

}
