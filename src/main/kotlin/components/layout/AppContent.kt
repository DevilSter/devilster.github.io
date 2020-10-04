package components.layout

import antdUi.uiButton
import antdUi.uiLayout
import react.*
import styled.css

external interface AppContentProps : RProps {

}

external interface AppContentState : RState {

}

private class AppContent : RComponent<AppContentProps, AppContentState>() {
    override fun RBuilder.render() {
        uiLayout {
            css {
                +AppLayoutStyles.contentStyles
            }

            uiButton("Just A Button") {

            }
        }
    }
}

fun RBuilder.appContent(handler: AppContentProps.() -> Unit): ReactElement {
    return child(AppContent::class) {
        attrs {
            handler()
        }
    }
}