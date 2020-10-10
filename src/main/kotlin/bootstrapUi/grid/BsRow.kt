package bootstrapUi.grid

import bootstrapUi.BsContentFormat
import bootstrapUi.BsItemsAlign
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
import styled.styledDiv

external interface BsRowProps : StyledProps {
    var flex: BsFlex?
    var contentFormat: BsContentFormat?
    var itemsAlign: BsItemsAlign?
}

private class BsRow : RComponent<BsRowProps, RState>() {
    override fun RBuilder.render() {

        styledDiv {
            css {
                classes.add("row")
                props.className?.let {
                    classes.add(it)
                }
                applyBsClasses(props)
            }

            children()
        }
    }
}

private fun CSSBuilder.applyBsClasses(props: BsRowProps) {
    props.flex?.let {
        classes.add(it.cls)
    }
    props.contentFormat?.let {
        classes.add(it.cls)
    }
    props.itemsAlign?.let {
        classes.add(it.cls)
    }
}

fun RBuilder.bsRow(
    className: String? = null,
    handler: StyledHandler<BsRowProps>? = null
): ReactElement =
    createStyled(BsRow::class) {
        setStyledPropsAndRunHandler(className, handler)
    }