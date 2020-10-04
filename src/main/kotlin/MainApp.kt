import antdUi.uiLayout
import components.layout.appContent
import components.layout.appHeader
import components.layout.appSider
import react.*

external interface MainAppProps : RProps {

}

external interface MainAppState : RState {

}

private class MainApp : RComponent<MainAppProps, MainAppState>() {
    init {
        kotlinext.js.require("antd/dist/antd.css")
    }

    override fun RBuilder.render() {
        uiLayout {
            appHeader {}
            uiLayout {
                appSider {}
                appContent {}
            }
        }
    }
}

fun RBuilder.mainApp(handler: MainAppProps.() -> Unit): ReactElement {
    return child(MainApp::class) {
        attrs {
            handler()
        }
    }
}