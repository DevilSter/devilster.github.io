package components.markdown

import kotlinext.js.asJsObject
import materialUi.UiTypographyVariant
import materialUi.themeContext
import materialUi.uiLink
import materialUi.uiTypography
import react.*
import styled.css
import styled.styledLi

external interface AppMarkdownProps : RProps

external interface AppMarkdownState : RState

private class AppMarkdown : RComponent<AppMarkdownProps, AppMarkdownState>() {

    override fun RBuilder.render() {
        themeContext.Consumer { theme ->
            val themedStyles = appMarkdownStyles(theme)

            markdownToJsx {
                attrs {
                    options = {
                        val overrides = {
                            val h1 = uiTypography(
                                gutterBottom = true,
                                variant = UiTypographyVariant.h5
                            )
                            val h2 = uiTypography(
                                gutterBottom = true,
                                variant = UiTypographyVariant.h6
                            )
                            val h3 = uiTypography(
                                gutterBottom = true,
                                variant = UiTypographyVariant.subtitle1
                            )
                            val h4 = uiTypography(
                                gutterBottom = true,
                                variant = UiTypographyVariant.caption,
                                paragraph = true
                            )
                            val p = uiTypography(
                                paragraph = true
                            )
                            val a = uiLink()
                            val li = styledLi {
                                css(themedStyles.listItem)

                                uiTypography {
                                    props
                                }
                            }
                        }.asJsObject()
                    }.asJsObject()
                }
            }
        }
    }
}

fun RBuilder.appMarkdown(handler: AppMarkdownProps.() -> Unit): ReactElement {
    return child(AppMarkdown::class) {
        attrs {
            handler()
        }
    }
}