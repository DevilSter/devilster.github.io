package components.post

import components.layout.appLayoutStyles
import domain.model.Post
import kotlinx.css.Image
import kotlinx.css.backgroundImage
import materialUi.*
import react.*
import styled.css
import styled.styledDiv

external interface AppPostOfTheDayProps : RProps {
    var post: Post
}

external interface AppPostOfTheDayState : RState {

}

class AppPostOfTheDay : RComponent<AppPostOfTheDayProps, AppPostOfTheDayState>() {
    override fun RBuilder.render() {
        themeContext.Consumer { theme ->
            val themedStyles = appPostStyles(theme)

            uiPaper {
                css {
                    backgroundImage = Image("url('${props.post.image}'")
                    +themedStyles.postOfTheDay
                }

                styledDiv {
                    css {
                        +themedStyles.postOfTheDayOverlay
                    }
                }

                uiGridContainer {
                    uiGridItem(md = UiGridSize.cells6) {
                        styledDiv {
                            css {
                                +themedStyles.postOfTheDayContent
                            }

                            uiTypography(
                                text = props.post.title,
                                component = "h1",
                                variant = UiTypographyVariant.h3,
                                color = UiTypographyColor.inherit,
                                gutterBottom = true
                            )

                            uiTypography(
                                text = props.post.description,
                                variant = UiTypographyVariant.h5,
                                color = UiTypographyColor.inherit,
                                paragraph = true
                            )

                            uiLink(
                                text = props.post.linkText,
                                hRef = props.post.link
                            ) {
                                attrs {
                                    variant = UiTypographyVariant.subtitle1
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

fun RBuilder.appPostOfTheDay(inPost: Post, handler: AppPostOfTheDayProps.() -> Unit): ReactElement {
    return child(AppPostOfTheDay::class) {
        attrs {
            post = inPost
            handler()
        }
    }
}