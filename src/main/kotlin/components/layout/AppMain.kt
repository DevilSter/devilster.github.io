package components.layout

import components.markdown.appMarkdown
import domain.model.Post
import materialUi.*
import react.*

external interface AppMainProps : RProps {
    var title: String
    var posts: List<Post>
}

external interface AppMainState : RState

private class AppMain : RComponent<AppMainProps, AppMainState>() {
    override fun RBuilder.render() {
        uiGridItem(
            xs = UiGridSize.cells12,
            md = UiGridSize.cells8
        ) {
            uiTypography(
                variant = UiTypographyVariant.h6,
                gutterBottom = true,
                text = props.title
            )
            uiDivider()

            appMarkdown {

            }
        }
    }

}

fun RBuilder.appMain(handler: AppMainProps.() -> Unit): ReactElement {
    return child(AppMain::class) {
        attrs {
            handler()
        }
    }
}