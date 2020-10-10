package bootstrapUi.button

import bootstrapUi.BsTextFormat
import bootstrapUi.createStyled
import bootstrapUi.setStyledPropsAndRunHandler
import kotlinx.css.CSSBuilder
import react.RBuilder
import react.RComponent
import react.RState
import react.ReactElement
import styled.StyledHandler
import styled.StyledProps
import styled.css
import styled.styledA

external interface BsButtonLinkProps : StyledProps {
    var textFormat: BsTextFormat?
    var btnType: BsButtonType?
    var btnSize: BsButtonSize?
    var href: String
}

private class BsButtonLink : RComponent<BsButtonLinkProps, RState>() {
    override fun RBuilder.render() {
        styledA {
            css {
                classes.add("btn")

                props.className?.let {
                    classes.add(it)
                }
                applyBsClasses(props)
            }

            attrs.href = props.href

            children()
        }
    }
}

private fun CSSBuilder.applyBsClasses(props: BsButtonLinkProps) {
    props.textFormat?.let {
        classes.add(it.cls)
    }
    props.btnType?.let {
        classes.add(it.cls)
    }
    props.btnSize?.let {
        classes.add(it.cls)
    }
}

fun RBuilder.bsButtonLink(
    href: String,
    type: BsButtonType? = null,
    size: BsButtonSize? = null,
    className: String? = null,
    handler: StyledHandler<BsButtonLinkProps>? = null
): ReactElement {
    return createStyled(BsButtonLink::class) {
        attrs.href = href

        type?.let { attrs.btnType = it }
        size?.let { attrs.btnSize = it }
        setStyledPropsAndRunHandler(className, handler)
    }
}