package bootstrapUi.grid

import bootstrapUi.*
import kotlinx.css.CSSBuilder
import react.RBuilder
import react.RComponent
import react.RState
import react.ReactElement
import styled.StyledHandler
import styled.StyledProps
import styled.css
import styled.styledDiv

external interface BsColumnProps : StyledProps {
    var cols: BsCols?
    var flex: BsFlex?
    var textAlign: BsTextAlign?
    var spacing: String?
    var contentFormat: BsContentFormat?
    var itemsAlign: BsItemsAlign?
}

private class BsColumn : RComponent<BsColumnProps, RState>() {
    override fun RBuilder.render() {
        styledDiv {
            css {
                props.className?.let {
                    classes.add(it)
                }
                applyBsClasses(props)
            }

            children()
        }
    }
}

private fun CSSBuilder.applyBsClasses(props: BsColumnProps) {
    props.cols?.let {
        classes.add(it.cls)
    }
    props.flex?.let {
        classes.add(it.cls)
    }
    props.spacing?.let {
        classes.add(it)
    }
    props.textAlign?.let {
        classes.add(it.cls)
    }
    props.contentFormat?.let {
        classes.add(it.cls)
    }
    props.itemsAlign?.let {
        classes.add(it.cls)
    }
}

fun RBuilder.bsRColumn(
    className: String? = null,
    handler: StyledHandler<BsColumnProps>? = null
): ReactElement =
    createStyled(BsColumn::class) {
        setStyledPropsAndRunHandler(className, handler)
    }

enum class BsCols(val cls: String) {
    COL("col"),
    COL1("col-1"),
    COL2("col-2"),
    COL3("col-3"),
    COL4("col-4"),
    COL5("col-5"),
    COL6("col-6"),
    COL7("col-7"),
    COL8("col-8"),
    COL9("col-9"),
    COL10("col-10"),
    COL11("col-11"),
    COL12("col-12")
}

