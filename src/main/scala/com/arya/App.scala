package com.arya

import slinky.core._
import slinky.core.annotations.react
import slinky.web.html._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

import com.arya.components.{Login, Register, Panel}

@JSImport("resources/App.css", JSImport.Default)
@js.native
object AppCSS extends js.Object

@JSImport("resources/login.svg", JSImport.Default)
@js.native
object LoginSVG extends js.Object

@react class App extends Component {
  type Props = Unit
  case class State(panel: String, displayLogin: Boolean)

  override def initialState =
    State(panel = "left", displayLogin = true)
  private val css = AppCSS

  def changeState() = {
    () => setState(prevState => {
      val switchDisplayLogin = !prevState.displayLogin
      val panel = if (switchDisplayLogin) "left" else "right"

      State(panel = panel, displayLogin = switchDisplayLogin)
    })
  }

  def render() = {
    val current = if (state.displayLogin) "Register" else "Login"
    val panel = state.panel
    div(className := "App")(
      div(
        className := "login",
        div(className := "container", if (state.displayLogin) {
          Login()
        } else {
          Register()
        }),
        Panel(current = current, panel = panel, onClick=changeState())
      )
    )
  }
}
