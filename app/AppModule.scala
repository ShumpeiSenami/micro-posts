import com.google.inject.AbstractModule
import services._

class AppModule extends AbstractModule{

  override def configure(): Unit = {
    bind(classOf[UserService]).to(classOf[UserServicesImpl])
    bind(classOf[MicroPostService]).to(classOf[MicroPostServiceImpl])
    bind(classOf[UserFollowService]).to(classOf[UserFollowServiceImpl])
    bind(classOf[FavoriteService]).to(classOf[FavoriteServiceImpl])
  }

}
