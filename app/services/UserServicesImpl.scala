package services

import javax.inject.Singleton

import models.User
import scalikejdbc.{AutoSession, DBSession}

import scala.util.Try

@Singleton
class UserServicesImpl extends UserService {

  // ユーザーの作成に成功した場合は、Success(Auto_IncrementによるID値を変えます）
  def create(user:User)(implicit dbSession:DBSession = AutoSession):Try[Long] = Try{
    User.create(user)
  }

  def findByEmail(email:String)(implicit dbSession:DBSession = AutoSession):Try[Option[User]] =
    Try{
      User.where('email -> email).apply().headOption
    }

  override def findAll(implicit dbSession: DBSession): Try[List[User]] = Try{
    User.findAll()
  }

  override def findById(id: Long)(implicit DBSession: DBSession): Try[Option[User]] = Try{
    User.findById(id)
  }

}