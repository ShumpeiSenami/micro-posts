package services

import models.{PagedItems, User}
import scalikejdbc.{AutoSession, DBSession}

import scala.util.Try
import skinny.Pagination

trait UserService{

  def create(user:User)(implicit dbsession:DBSession = AutoSession):Try[Long]

  def findByEmail(email:String)(implicit dbSession: DBSession = AutoSession):Try[Option[User]]

  def findAll(pagination: Pagination)(implicit dbSession:DBSession = AutoSession):Try[PagedItems[User]]

  def findById(id:Long)(implicit DBSession: DBSession =  AutoSession):Try[Option[User]]
}