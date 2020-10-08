import kotlinx.browser.document
import kotlinx.browser.window
import materialUi.uiStylesProvider
import react.dom.render

fun main() {
    window.onload = {
        render(document.getElementById("root")) {
            uiStylesProvider("jss-insertion-point") {
                mainApp {}
            }
        }
    }
}