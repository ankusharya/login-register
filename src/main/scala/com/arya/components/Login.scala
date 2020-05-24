package com.arya.components

import slinky.core.StatelessComponent
import slinky.core.annotations.react
import slinky.web.html._

import com.arya.LoginSVG

@react class Login extends StatelessComponent {
    type Props = Unit

  def render = {
    div(
      className := "base-container",
        div (
          className := "header", "Login"
      ),
      div(
        className := "content",
        div(className := "image", img(src := LoginSVG.asInstanceOf[String])),
        div(
          className := "form",
          div(
            className := "form-group",
            label(htmlFor := "username", "Username"),
            input(
              `type` := "text",
              name := "username",
              placeholder := "username"
            )
          ),
          div(
            className := "form-group",
            label(htmlFor := "password", "Password"),
            input(
              `type` := "text",
              name := "password",
              placeholder := "password"
            )
          )
        ),
          div (
            className := "footer",
            button(`type` := "button", className := "btn", "Login")
        )
      )
    )
  }
}

