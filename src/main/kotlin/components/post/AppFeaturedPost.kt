package components.post

import domain.model.Post
import materialUi.*
import react.*
import styled.css
import styled.styledDiv
import kotlin.js.Date

external interface AppFeaturedPostProps : RProps {
    var post: Post
}

external interface AppFeaturedPostState : RState {}

class AppFeaturedPost : RComponent<AppFeaturedPostProps, AppFeaturedPostState>() {
    override fun RBuilder.render() {
        themeContext.Consumer { theme ->
            val themedStyles = appPostStyles(theme)

            uiGridItem(
                xs = UiGridSize.cells12,
                md = UiGridSize.cells6
            ) {
                uiCardActionArea {
                    attrs {
                        component = "a"
                        href = "#"
                    }
                    uiCard {
                        css(themedStyles.card)

                        styledDiv {
                            css(themedStyles.cardDetails)

                            uiCardContent {
                                uiTypography(
                                    component = "h2",
                                    variant = UiTypographyVariant.h5,
                                    text = props.post.title
                                )
                                uiTypography(
                                    variant = UiTypographyVariant.subtitle1,
                                    color = UiTypographyColor.secondary,
                                    text = Date(props.post.date).toDateString()
                                )
                                uiTypography(
                                    variant = UiTypographyVariant.subtitle1,
                                    paragraph = true,
                                    text = props.post.description
                                )
                                uiTypography(
                                    variant = UiTypographyVariant.subtitle1,
                                    color = UiTypographyColor.primary,
                                    text = "continue reading"
                                )
                            }
                        }
                        uiHidden(
                            xsDown = true
                        ) {
                            uiCardMedia(
                                image = props.post.image,
                                title = props.post.title
                            ) {
                                css(themedStyles.cardMedia)
                            }
                        }
                    }
                }
            }
        }
    }
}

fun RBuilder.appFeaturedPost(inPost: Post, handler: AppFeaturedPostProps.() -> Unit): ReactElement {
    return child(AppFeaturedPost::class) {
        attrs {
            post = inPost
            handler()
        }
    }
}