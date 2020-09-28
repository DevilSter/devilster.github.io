import domain.model.Post
import kotlinx.browser.window
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.await
import kotlinx.coroutines.launch
import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import react.*
import react.dom.h2
import react.dom.p
import styled.styledDiv

external interface AppProps : RProps {
    var name: String
}

external interface AppState : RState {
    var posts: List<Post>
}

private class App : RComponent<AppProps, AppState>() {

    override fun AppState.init() {
        posts = listOf<Post>()
    }

    override fun componentDidMount() {
        val mainScope = MainScope()
        mainScope.launch {
            val fetchedPosts = fetchPosts("https://jsonplaceholder.typicode.com/posts")
            setState {
                posts = fetchedPosts
            }
        }
    }

    override fun RBuilder.render() {
        styledDiv {
            for (post in state.posts) {
                styledDiv {
                    key = post.id.toString()
                    h2 {
                        +post.title
                    }
                    p {
                        +post.body
                    }
                }
            }
        }
    }


    suspend fun fetchPosts(url: String): List<Post> {
        val postsJson =
            window.fetch(url)
                .await()
                .text()
                .await()

        return Json.decodeFromString(postsJson)
    }
}

fun RBuilder.app(handler: AppProps.() -> Unit): ReactElement {
    return child(App::class) {
        attrs {
            handler()
        }
    }
}

//private class App : RComponent<AppProps, AppState>() {
//
//    /**
//     * Первоначальная инициализация state
//     */
//    override fun AppState.init() {
//        someText = "Initial State"
//    }
//
//    override fun RBuilder.render() {
//        styledDiv {
//            css {
//                +AppStyles.appContainer
//            }
//
//            styledHeader {
//                css {
//                    +AppStyles.appHeader
//                }
//
//                styledImg(src = "/logo.svg") {
//                    css {
//                        +AppStyles.appLogo
//                    }
//                }
//
//                p {
//                    +"From Props: ${props.name}"
//                }
//
//                p {
//                    +"From State: ${state.someText}"
//                }
//
//                styledButton {
//                    attrs {
//                        onClickFunction = {
//                            setState {
//                                someText = "Press Me Button Clicked"
//                            }
//                        }
//                    }
//
//                    +"Press Me"
//                }
//            }
//        }
//    }
//}