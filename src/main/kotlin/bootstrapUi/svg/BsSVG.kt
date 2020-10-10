package bootstrapUi.svg

import bootstrapUi.createStyled
import bootstrapUi.setStyledPropsAndRunHandler
import kotlinx.html.*
import react.*
import react.dom.tag
import react.dom.title
import styled.*

external interface BsSVGProps : StyledProps {
    var xmlns: String?
    var width: String?
    var height: String?
    var fill: BsSVGColorOptions?
    var stroke: BsSVGColorOptions?
    var strokeLinecap: BsSVGStrokeOptions?
    var strokeLinejoin: BsSVGStrokeOptions?
    var strokeWidth: Int?
    var viewBox: String?
    var focusable: Boolean

    var role: String?

    var title: String?
}

class BsSVG : RComponent<BsSVGProps, RState>() {
    override fun RBuilder.render() {
        styledSvg {
            fillAttributesFromProps(props)

            css {
                props.className?.let {
                    classes.add(it)
                }
            }

            props.title?.let {
                title(content = it)
            }

            children()
        }
    }
}

private fun StyledDOMBuilder<SVG>.fillAttributesFromProps(props: BsSVGProps) {
    with(props) {
        xmlns?.let { attrs["xmlns"] = it }
        width?.let { attrs["width"] = it }
        height?.let { attrs["height"] = it }
        fill?.let { attrs["fill"] = it.value }
        stroke?.let { attrs["stroke"] = it.value }
        strokeLinecap?.let { attrs["strokeLinecap"] = it.value }
        strokeLinejoin?.let { attrs["strokeLinejoin"] = it.value }
        strokeWidth?.let { attrs["strokeWidth"] = it }
        viewBox?.let { attrs["viewBox"] = it }

        attrs["focusable"] = focusable

        role?.let { attrs.role = it }
    }
}

fun RBuilder.bsSVG(
    title: String? = null,
    className: String? = null,
    handler: StyledHandler<BsSVGProps>? = null
): ReactElement {
    return createStyled(BsSVG::class) {
        title?.let {
            attrs.title = it
        }

        setStyledPropsAndRunHandler(className, handler)
    }
}

enum class BsSVGStrokeOptions(val value: String) {
    ROUND("round")
}

enum class BsSVGColorOptions(val value: String) {
    NONE("none"),
    CURRENT_COLOR("currentColor")
}