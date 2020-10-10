package bootstrapUi

import react.*
import styled.StyledHandler
import styled.StyledProps
import styled.styledDiv

external interface BsContainerProps : StyledProps

private class BsContainer : RComponent<BsContainerProps, RState>() {

    override fun RBuilder.render() {
        styledDiv {
            css.classes.add("container")
            props.className?.let {
                css.classes.add(it)
            }

            children()
        }
    }
}


fun RBuilder.bsContainer(
    className: String? = null,
    handler: StyledHandler<BsContainerProps>? = null
): ReactElement {
    return createStyled(BsContainer::class) {
        setStyledPropsAndRunHandler(className, handler)
    }
}