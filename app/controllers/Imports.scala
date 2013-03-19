package controllers

import play.api.libs.json.Writes
import com.mongodb.casbah.Imports._
import org.joda.time.DateTime
import play.api.mvc._
import data.UserDao
import models.User
import play.api.libs.json.JsString
import scala.Some
import play.api.libs.json.JsNumber

/**
 * Contains custom conversions for JSON serialization for common types used by application
 */
trait Conversions {

  /** for ObjectId, internal ID type of MongoDB */
  implicit object ObjectIdWrites extends Writes[ObjectId] {
    def writes(value: ObjectId) = JsString(value.toString)
  }

  /** for DateTime, used to represent dates and timestamps */
  implicit object DateTimeWrites extends Writes[DateTime] {
    def writes(value: DateTime) = JsString(value.toString("yyyy-MM-dd'T'HH:mm:ss.SSS")) // yyyy-MM-ddTHH:mm:ss.SSS (use format in parentheses to change)
  }

  /** for BigDecimal, used to represent money */
  implicit object BigDecimalWrites extends Writes[BigDecimal] {
    def writes(o: BigDecimal) = JsNumber(o)
  }
}

object Conversions extends Conversions
