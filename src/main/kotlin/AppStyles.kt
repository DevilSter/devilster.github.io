import kotlinx.css.*
import kotlinx.css.properties.*
import styled.StyleSheet
import styled.animation

object AppStyles : StyleSheet("AppStyles", isStatic = false) {
    val appContainer by css {
        textAlign = TextAlign.center
    }

    val appLogo by css {
        height = 40.vmin
        pointerEvents = PointerEvents.none

        media("(prefers-reduced-motion: no-preference)") {
            animation(iterationCount = IterationCount.infinite, duration = 20.s, timing = Timing.linear) {
                from {
                    transform {
                        rotate(0.deg)
                    }
                }
                to {
                    transform {
                        rotate(360.deg)
                    }
                }
            }
        }
    }

    val appHeader by css {
        backgroundColor = rgb(40, 44, 52)
        minHeight = 100.vh
        display = Display.flex
        flexDirection = FlexDirection.column
        alignItems = Align.center
        justifyContent = JustifyContent.center
        fontSize = (10.px + 2.vmin)
        color = Color.white
    }

    val appLink by css {
        color = rgb(97, 218, 251)
    }
}