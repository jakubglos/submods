package data

import com.mongodb.casbah.Imports._
import com.mongodb.casbah.Implicits._
import com.novus.salat._
import com.novus.salat.global._
import com.novus.salat.dao.SalatDAO
import data.Helpers._
import models.User
import org.joda.time.DateTime

/**
 * DAO for User domain entity
 */
object UserDao extends SalatDAO[User, ObjectId](MongoDBSetup.mongoDB("users")) {

  lazy val users = collection

  def findByUsername(username: String): Option[User]  = {
    val query = MongoDBObject("username" -> username)
    users.findOne(query).map(grater[User].asObject(_))
  }

  def findAll(): List[User] = {
    users.map(grater[User].asObject(_)).toList.sortBy(r => (r.lastName, r.firstName))
  }

}