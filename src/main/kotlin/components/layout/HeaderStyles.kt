package components.layout

import kotlinx.css.*
import kotlinx.css.properties.LineHeight
import styled.StyleSheet

object HeaderStyles : StyleSheet("HeaderStyles", isStatic = false) {
    val blogHeader by css {
        classes = mutableListOf("py-3")

        lineHeight = LineHeight("1")
        borderBottom = "1px solid #e5e5e5"
    }

    val blogHeaderLogo by css {
        fontFamily = """
            "Playfair Display", Georgia, "Times New Roman", serif 
        """.trimIndent()
        fontSize = 2.25.rem
    }
}