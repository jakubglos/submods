package data

import com.mongodb.casbah.MongoConnection
import play.api.Play.current
import com.mongodb.casbah.commons.conversions.scala.RegisterJodaTimeConversionHelpers

trait MongoDBSetup {
  val MONGODB_URL = "mongoDB.url"
  val MONGODB_PORT = "mongoDB.port"
  val MONGODB_DB = "mongoDB.db"
  val MONGODB_USERNAME = "mongoDB.username"
  val MONGODB_PASSWORD = "mongoDB.password"
}

object MongoDBSetup extends MongoDBSetup {

  private[this] val conf = current.configuration

  val url = conf.getString(MONGODB_URL).getOrElse("localhost")
  val port = conf.getInt(MONGODB_PORT).getOrElse(27017)
  val db = conf.getString(MONGODB_DB).getOrElse("liga_vynimocnych")

  val mongoDB = MongoConnection(url, port)(db)

  conf.getString(MONGODB_USERNAME) map { username =>
    conf.getString(MONGODB_PASSWORD) map { password =>
      if (! mongoDB.authenticate(username, password)) {
        sys.error("Cannot access MongoDB at: " + url + ":" + port + " under: " + username)
      }
    }
  }

  RegisterJodaTimeConversionHelpers()
}
