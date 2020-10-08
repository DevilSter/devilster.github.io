package components.markdown

import materialUi.createStyled
import materialUi.setStyledPropsAndRunHandler
import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler
import styled.StyledProps

@JsModule("markdown-to-jsx")
@JsNonModule
private external val markdownToJsxModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val ReactMarkdown: RComponent<ReactMarkdownProps, RState> = markdownToJsxModule.ReactMarkdown

external interface ReactMarkdownProps : StyledProps {
    var options: dynamic
}

fun RBuilder.markdownToJsx(
    className: String? = null,
    handler: StyledHandler<ReactMarkdownProps>? = null
) = createStyled(ReactMarkdown) {
    setStyledPropsAndRunHandler(className, handler)
}