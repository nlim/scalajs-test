package tutorial.webapp

import scala.scalajs.js.JSApp
import org.scalajs.dom
import dom.document
import scala.scalajs.js.annotation.JSExport
import org.scalajs.jquery.jQuery

object TutorialApp extends JSApp {
  def main(): Unit = {
    jQuery(setupUI)
  }

  def setupUI: Unit = {
    jQuery("""<button type="button">Click me!</button>""").click(addClickedMessage _).appendTo(jQuery("body"))
    jQuery("body").append("<p>Hello World</p>")
  }

  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    val textNode = document.createTextNode(text)
    parNode.appendChild(textNode)
    targetNode.appendChild(parNode)
  }

  def addToBody(message: String): Unit = {
    jQuery("body").append("<p>" + message + "</p>")
  }

  @JSExport
  def addClickedMessage(): Unit = {
    addToBody("You clicked the button!")
  }
}
