package controllers

import javax.inject._
import play.api.i18n.I18nSupport
import play.api.mvc._
import jp.t2v.lab.play2.auth.OptionalAuthElement
import services.UserService


@Singleton
class HomeController @Inject()(
                              val userService: UserService,
                              val components: ControllerComponents
                              ) extends AbstractController(components)
  with I18nSupport
  with AuthConfigSupport
  with OptionalAuthElement {

  def index():Action[AnyContent] = StackAction { implicit request =>
    Ok(views.html.index(loggedIn))
  }
}
