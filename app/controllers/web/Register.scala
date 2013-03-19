package controllers.web

import _root_.data.UserDao
import play.api._
import data.Form
import data.Forms.{tuple, nonEmptyText, text}
import play.api.mvc._
import models._
import controllers.Conversions._

object Register extends Controller {
  def registrationForm = Form(
    tuple(
      "username" -> nonEmptyText,
      "password" -> nonEmptyText,
      "confirm"  -> nonEmptyText,
      "firstName" -> text,
      "lastName" -> text
    ).verifying(
      "Passwords must match",
      fields => {
        val (_, password, confirm, _, _) = fields
        password == confirm
      }
    )
  )

  def list() = Action { implicit request =>
    Ok(views.html.registration.list(UserDao.findAll()))
  }

  def edit() = Action { implicit request =>
    Ok(views.html.registration.register(registrationForm))
  }

  def register() = Action { implicit request =>
    val formAfter = registrationForm.bindFromRequest
    formAfter.fold(
      form => BadRequest(views.html.registration.register(form)),
      registration => {
        val (username, password, _, firstName, lastName) = registration
        UserDao.save(User(username = username, password = password, firstName = Option(firstName), lastName = Option(lastName)))
        Redirect(routes.Register.list()).flashing("message" -> "User Registered!")
      }
    )
  }
}
