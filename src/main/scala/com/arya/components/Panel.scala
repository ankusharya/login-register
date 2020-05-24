package com.arya.components

import slinky.core._
import slinky.web.html._
import slinky.core.annotations.react

@react class Panel extends StatelessComponent {
  case class Props(current: String, panel: String, onClick: () => Unit)

  def render = {
    div(
      className := s"right-side ${props.panel}",
      onClick := { () => props.onClick() },
      div(
        className := "inner-container",
        div(className := "text", props.current)
      )
    )
  }
}
