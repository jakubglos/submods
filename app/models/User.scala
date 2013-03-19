package models

import com.mongodb.casbah.commons.TypeImports.ObjectId
import com.novus.salat.annotations._
import org.joda.time._

/**
 * Domain entity for User
 */
case class User(
    @Key("_id") id: ObjectId = new ObjectId,
    username: String,
    password: String,
    firstName: Option[String] = None, // TODO: why an option
    lastName: Option[String] = None, // TODO: why an option
    email: Option[String] = None,
    gender: Option[Int] = None)
     {
  require(username != null)
  require(password != null)

  def fullName: String =
    lastName.map{ lastNameValue =>
      firstName.map { firstNameValue =>
        firstNameValue + " " + lastNameValue
      }.getOrElse(lastNameValue)
    }.getOrElse(username)

  override def hashCode(): Int = this.id.hashCode()

  override def equals(that: Any): Boolean = {
    if (that != null && that.isInstanceOf[User]) that.asInstanceOf[User].id == this.id
    else false
  }

}