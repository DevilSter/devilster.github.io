package components.layout

import domain.model.Post
import react.*

external interface AppMainProps : RProps {
    var title: String
    var posts: List<Post>
}

external interface AppMainState : RState

private class AppMain : RComponent<AppMainProps, AppMainState>() {
    override fun RBuilder.render() {

    }

}

fun RBuilder.appMain(handler: AppMainProps.() -> Unit): ReactElement {
    return child(AppMain::class) {
        attrs {
            handler()
        }
    }
}