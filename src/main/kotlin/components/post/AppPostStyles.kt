package components.post

import kotlinx.css.*
import materialUi.UiBreakpoint
import materialUi.UiTheme
import materialUi.spacingUnits
import materialUi.up
import styled.StyleSheet

interface AppPostStyles {
    val postOfTheDay: RuleSet
    val postOfTheDayOverlay: RuleSet
    val postOfTheDayContent: RuleSet
    val card: RuleSet
    val cardDetails: RuleSet
    val cardMedia: RuleSet
}

fun appPostStyles(theme: UiTheme): AppPostStyles =
    object : StyleSheet("AppPostStyles", isStatic = false), AppPostStyles {
        override val postOfTheDay by css {
            position = Position.relative
            backgroundColor = Color(theme.palette.grey._800)
            color = Color(theme.palette.common.white)
            marginBottom = 4.spacingUnits
            backgroundImage = Image("url('https://source.unsplash.com/random')")
            backgroundSize = "cover"
            backgroundRepeat = BackgroundRepeat.noRepeat
            backgroundPosition = "center"
        }
        override val postOfTheDayOverlay by css {
            position = Position.absolute
            top = 0.px
            bottom = 0.px
            left = 0.px
            right = 0.px
            backgroundColor = Color("rgba(0,0,0,.3)")
        }
        override val postOfTheDayContent by css {
            position = Position.relative
            padding = 3.spacingUnits.toString()
            media(theme.breakpoints.up(UiBreakpoint.md)) {
                padding = 6.spacingUnits.toString()
                paddingRight = 0.px
            }
        }
        override val card by css {
            display = Display.flex
        }
        override val cardDetails by css {
            flex(1.0)
        }
        override val cardMedia by css {
            width = 160.px
        }
    }