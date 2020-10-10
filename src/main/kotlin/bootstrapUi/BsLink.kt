package bootstrapUi

import kotlinx.css.CSSBuilder
import react.RBuilder
import react.RComponent
import react.RState
import react.ReactElement
import styled.StyledHandler
import styled.StyledProps
import styled.css
import styled.styledA

external interface BsLinkProps : StyledProps {
    var textFormat: BsTextFormat?
    var href: String
    var ariaLabel: String?
}

private class BsLink : RComponent<BsLinkProps, RState>() {
    override fun RBuilder.render() {
        styledA {
            css {
                props.className?.let {
                    classes.add(it)
                }
                applyBsClasses(props)
            }

            attrs {
                href = props.href

                props.ariaLabel?.let {
                    attributes["area-label"] = it
                }
            }

            children()
        }
    }
}

private fun CSSBuilder.applyBsClasses(props: BsLinkProps) {
    props.textFormat?.let {
        classes.add(it.cls)
    }
}

fun RBuilder.bsLink(
    href: String,
    className: String? = null,
    handler: StyledHandler<BsLinkProps>? = null
): ReactElement {
    return createStyled(BsLink::class) {
        attrs.href = href

        setStyledPropsAndRunHandler(className, handler)
    }
}
