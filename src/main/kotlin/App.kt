import kotlinx.html.js.onClickFunction
import react.*
import react.dom.p
import styled.*

external interface AppProps : RProps {
    var name: String
}

external interface AppState : RState {
    var someText: String?
}

private class App : RComponent<AppProps, AppState>() {

    /**
     * Первоначальная инициализация state
     */
    override fun AppState.init() {
        someText = "Initial State"
    }

    override fun RBuilder.render() {
        styledDiv {
            css {
                +AppStyles.appContainer
            }

            styledHeader {
                css {
                    +AppStyles.appHeader
                }

                styledImg(src = "/logo.svg") {
                    css {
                        +AppStyles.appLogo
                    }
                }

                p {
                    +"From Props: ${props.name}"
                }

                p {
                    +"From State: ${state.someText}"
                }

                styledButton {
                    attrs {
                        onClickFunction = {
                            setState {
                                someText = "Press Me Button Clicked"
                            }
                        }
                    }

                    +"Press Me"
                }
            }
        }
    }
}

fun RBuilder.app(handler: AppProps.() -> Unit): ReactElement {
    return child(App::class) {
        attrs {
            handler()
        }
    }
}