package components.layout

import kotlinx.css.*
import styled.StyleSheet

object AppLayoutStyles : StyleSheet("AppLayoutStyles", isStatic = false) {
    val siderMenu by css {
        height = 100.pct
    }

    val contentStyles by css {
        padding = "0 24px 24px"
    }
}