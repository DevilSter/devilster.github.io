import domain.model.Post
import react.*
import kotlin.js.Date

external interface MainAppProps : RProps {
    var featuredPosts: List<Post>
}

external interface MainAppState : RState {
    var themeColor: String
}

private class MainApp : RComponent<MainAppProps, MainAppState>() {
    val postOfTheDay = Post(
        id = 1,
        userId = 1,
        title = "Title of a longer featured blog post",
        description = "Multiple lines of text that form the lede, informing new readers quickly and efficiently about what's most interesting in this post's contents.",
        body = "Test Post Body",
        image = "https://source.unsplash.com/random",
        linkText = "continue reading...",
        link = "#",
        date = Date.now()
    )

    override fun RBuilder.render() {
        Fragment {

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