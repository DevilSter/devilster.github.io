package components.markdown

import kotlinx.css.RuleSet
import kotlinx.css.marginTop
import materialUi.UiTheme
import materialUi.spacingUnits
import styled.StyleSheet

interface AppMarkdownStyles {
    val listItem: RuleSet
}

fun appMarkdownStyles(theme: UiTheme) : AppMarkdownStyles =
    object : StyleSheet("AppMarkdownStyles", isStatic = false), AppMarkdownStyles {
        override val listItem by css {
            marginTop = 1.spacingUnits
        }
    }