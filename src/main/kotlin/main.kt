import kotlinx.browser.document
import kotlinx.browser.window
import react.dom.render
import styled.injectGlobal

fun main() {
    injectGlobal(globalStyles.toString())

    window.onload = {
        render(document.getElementById("root")) {
            mainApp {}
        }
    }
}