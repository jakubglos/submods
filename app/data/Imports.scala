package data

import com.mongodb.casbah.commons.conversions.MongoConversionHelper
import org.joda.time.{LocalDateTime, LocalDate}
import org.bson.{BSON, Transformer}
import com.mongodb.casbah.Imports._
import com.novus.salat.dao.SalatMongoCursor

/**
 * Contains implicit conversions for controllers
 */
trait Implicits {
  import com.mongodb.casbah.Imports._

  /**
   * Implicit conversion from String to ObjectId
   */
  implicit def stringToObjectId(idAsString: String): ObjectId = new ObjectId(idAsString)
}

/**
 * Contains helper methods and implicit conversions for DAOs
 */
trait Helpers extends Implicits {

  /**
   * Implicit conversion for queries, it creates additional operators.
   *
   * Basic equals/assignment operator:
   * - anything in form <code>"field" $eq value</code> translates to <code>DBObject("field" -> value)</code>
   */
  implicit def queryOperatorAdditions(field: String) = new {
    protected val _field = field
  } with EqualsOp

  trait EqualsOp {
    protected def _field: String
    def $eq[T](target: T) = MongoDBObject(_field -> target)
  }

  /**
   * Pimp my library for cursors, it allows additional methods on
   */
  implicit def cursorAdditions[T <: AnyRef](cursor: SalatMongoCursor[T]) = new {
    protected val _cursor = cursor
  } with CursorOperations[T]

  trait CursorOperations[T <: AnyRef] {
    protected def _cursor: SalatMongoCursor[T]
    def headOption : Option[T] = if (_cursor.hasNext) Some(_cursor.next()) else None
  }

  /**
   *
   */
  implicit object LocalDateTimeDoNOk extends JDKDateOk with ValidDateOrNumericType[org.joda.time.LocalDateTime]

  /**
   * Alias for empty DBObject, for queries without criteria
   */
  implicit val emptyQuery = (ignore: Unit) => MongoDBObject.empty
}

/** Objects for easy importing */
object Implicits extends Implicits
object Helpers extends Helpers

