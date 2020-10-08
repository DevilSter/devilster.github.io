import components.layout.HeaderNavLink
import components.layout.appHeader
import components.layout.appLayoutStyles
import components.layout.appMain
import components.post.appFeaturedPost
import components.post.appPostOfTheDay
import components.post.appPostStyles
import domain.model.Post
import materialUi.*
import react.*
import react.dom.main
import styled.css
import kotlin.js.Date

external interface MainAppProps : RProps {
    var featuredPosts: List<Post>
}

external interface MainAppState : RState {
    var themeColor: String
}

private class MainApp : RComponent<MainAppProps, MainAppState>() {
    val sectionsGlobal = listOf(
        HeaderNavLink("Technology", "#"),
        HeaderNavLink("Design", "#"),
        HeaderNavLink("Culture", "#"),
        HeaderNavLink("Business", "#"),
        HeaderNavLink("Politics", "#"),
        HeaderNavLink("Opinion", "#"),
        HeaderNavLink("Science", "#"),
    )

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
            uiCssBaseline()

            @Suppress("UnsafeCastFromDynamic")
            val themeOptions: UiThemeOptions = js("({palette: { type: 'placeholder', primary: {main: 'placeholder'}}})")
            themeOptions.palette?.type = state.themeColor
            themeOptions.palette?.primary.main = Colors.Blue.shade500.toString()

            uiThemeProvider(createMaterialUiTheme(themeOptions)) {

                themeContext.Consumer { theme ->
                    val themedStyles = appLayoutStyles(theme)

                    uiContainer {
                        appHeader {
                            attrs {
                                title = "Blog"
                                sections = sectionsGlobal
                            }
                        }
                        main {
                            appPostOfTheDay(inPost = postOfTheDay) {}

                            uiGridContainer(
                                spacing = UiGridSpacing.spacing4
                            ) {
                                featuredPosts.map { post ->
                                    appFeaturedPost(post) {
                                        attrs {
                                            key = post.id.toString()
                                        }
                                    }
                                }
                            }

                            uiGridContainer(
                                spacing = UiGridSpacing.spacing5
                            ) {
                                css(themedStyles.mainGrid)

                                appMain {

                                }
                            }
                        }
                    }
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