package services

import javax.inject.Singleton
import models.{PagedItems, User}
import scalikejdbc.{AutoSession, DBSession}
import skinny.Pagination

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

   def findAll(pagination: Pagination)(implicit dbSession: DBSession = AutoSession): Try[PagedItems[User]] = Try{
    PagedItems[User](
      pagination,
      User.countAllModels(),
      User.findAllWithPagination(pagination, Seq(User.defaultAlias.id.asc))
    )
  }

  override def findById(id: Long)(implicit DBSession: DBSession): Try[Option[User]] = Try{
    User.findById(id)
  }

}