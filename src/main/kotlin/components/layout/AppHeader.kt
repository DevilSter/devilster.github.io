package components.layout

import materialUi.*
import react.*
import styled.css

external interface AppHeaderProps : RProps {
    var title: String?
    var sections: List<HeaderNavLink>?
}

external interface AppHeaderState : RState {

}

private class AppHeader : RComponent<AppHeaderProps, AppHeaderState>() {
    override fun RBuilder.render() {
        Fragment {
            themeContext.Consumer { theme ->
                val themedStyles = appLayoutStyles(theme)

                uiToolbar {
                    css {
                        +themedStyles.header
                    }
                    uiButton("Подписаться") {
                        attrs {
                            size = UiButtonSize.small
                        }
                    }
                    uiTypography(text = props.title) {
                        attrs {
                            component = "h2"
                            variant = UiTypographyVariant.h5
                            color = UiTypographyColor.inherit
                            align = UiTypographyAlign.center
                            noWrap = true
                        }
                        css {
                            +themedStyles.toolbarTitle
                        }
                    }
                    uiIconButton {
                        uiIcon("search")
                    }
                    uiButton("Войти") {
                        attrs {
                            size = UiButtonSize.small
                            variant = UiButtonVariant.outlined
                        }
                    }
                }
                uiToolbar {
                    attrs {
                        component = "nav"
                        variant = UiToolbarVariant.dense
                    }
                    css {
                        +themedStyles.toolbarMenu
                    }
                    props.sections?.map {
                        uiLink(
                            text = it.title,
                            hRef = it.url
                        ) {
                            attrs {
                                color = UiTypographyColor.inherit
                                noWrap = true
                                key = it.title
                                variant = UiTypographyVariant.body2
                            }
                        }
                    }
                }
            }

        }
    }
}

fun RBuilder.appHeader(handler: AppHeaderProps.() -> Unit): ReactElement {
    return child(AppHeader::class) {
        attrs {
            handler()
        }
    }
}

data class HeaderNavLink(val title: String, val url: String)