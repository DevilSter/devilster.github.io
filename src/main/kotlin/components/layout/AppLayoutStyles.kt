package components.layout

import kotlinx.css.*
import materialUi.*
import styled.StyleSheet

interface AppLayoutStyles {
    val header: RuleSet
    val toolbarTitle: RuleSet
    val toolbarMenu: RuleSet
    val toolbarLink: RuleSet
    val mainGrid: RuleSet
}


fun appLayoutStyles(theme: UiTheme): AppLayoutStyles =
    object : StyleSheet("AppLayoutStyles", isStatic = false), AppLayoutStyles {
        override val header by css {
            borderBottom = "1px solid ${theme.palette.divider}"
        }
        override val toolbarTitle by css {
            flex(1.0)
        }
        override val toolbarMenu by css {
            justifyContent = JustifyContent.spaceBetween
            overflowX = Overflow.auto
        }
        override val toolbarLink by css {
            padding = 1.spacingUnits.toString()
            flexShrink = 1.0
        }
        override val mainGrid by css {
            marginTop = 3.spacingUnits
        }
    }