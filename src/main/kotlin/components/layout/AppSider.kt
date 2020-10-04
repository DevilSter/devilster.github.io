package components.layout

import antdUi.*
import kotlinext.js.asJsObject
import react.*
import styled.css

external interface AppSiderProps : RProps {

}

external interface AppSiderState : RState {

}

private class AppSider : RComponent<AppSiderProps, AppSiderState>() {
    override fun RBuilder.render() {
        uiSider(className = "site-layout-background") {
            attrs {
                width = "200"
            }

            uiMenu {
                attrs {
                    mode = "inline"
                    defaultSelectedKeys = js("['1']")
                    defaultOpenKeys = js("['sub1']")
                }

                css {
                    +AppLayoutStyles.siderMenu
                }

                for (y in 0..2) {
                    uiSubmenu {
                        attrs {
                            key = "sub ${y + 1}"
                            title = "sub nav ${y + 1}"
                            icon = when (y) {
                                1 -> LaptopOutlined {}
                                2 -> NotificationOutlined {}
                                else -> uiIconsUserOutlined {}
                            }
                        }

                        for (i in 1..4) {
                            uiMenuItem {
                                attrs {
                                    key = (i + y * 4).toString()
                                }
                                +"option ${i + y * 4}"
                            }
                        }
                    }
                }
            }
        }
    }
}

fun RBuilder.appSider(handler: AppSiderProps.() -> Unit): ReactElement {
    return child(AppSider::class) {
        attrs {
            handler()
        }
    }
}