import bootstrapUi.bsContainer
import components.layout.header
import kotlinext.js.require
import react.*

external interface MainAppProps : RProps

external interface MainAppState : RState

private class MainApp : RComponent<MainAppProps, MainAppState>() {
    init {
        require("bootstrap/dist/css/bootstrap.css")
    }

    override fun RBuilder.render() {
        Fragment {
            bsContainer("classsNew") {
                header {

                }
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
