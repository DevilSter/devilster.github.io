import kotlinx.css.*
import styled.StyleSheet

val globalStyles = CSSBuilder().apply {
    body {
        margin(0.px)
        padding(0.px)
    }
}

object MainAppStyles : StyleSheet("MainAppStyles", isStatic = false) {

}