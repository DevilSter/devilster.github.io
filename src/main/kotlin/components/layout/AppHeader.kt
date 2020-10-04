package components.layout

import antdUi.uiHeader
import antdUi.uiMenu
import antdUi.uiMenuItem
import react.*
import react.dom.div

external interface AppHeaderProps : RProps {

}

external interface AppHeaderState : RState {

}

private class AppHeader : RComponent<AppHeaderProps, AppHeaderState>() {
    private val menuItems = mapOf<Int, String>(
        1 to "Nav 1",
        2 to "Nav 2",
        3 to "Nav 3",
    )

    override fun RBuilder.render() {
        uiHeader(className = "header") {
            div("logo") {}

            uiMenu {
                attrs {
                    theme = "dark"
                    mode = "horizontal"
                    defaultSelectedKeys = js(
                        "['2']"
                    )
                }
                for ((index, value) in menuItems) {
                    uiMenuItem {
                        attrs {
                            key = index.toString()
                        }
                        +value
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