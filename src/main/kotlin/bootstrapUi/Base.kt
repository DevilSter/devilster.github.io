package bootstrapUi

import react.*
import react.dom.style
import styled.*
import kotlin.reflect.KClass

fun <P : StyledProps> RBuilder.createStyled(
    component: RComponent<P, RState>,
    addAsChild: Boolean = true,
    handler: StyledHandler<P>
): ReactElement {
    val builder = StyledElementBuilder<P>(component)
    handler(builder)
    return if (addAsChild) child(builder.create()) else builder.create()
}

fun <P : StyledProps> RBuilder.createStyled(
    componentClass: KClass<out RComponent<P, RState>>,
    addAsChild: Boolean = true,
    handler: StyledHandler<P>
): ReactElement {
    val builder = StyledElementBuilder<P>(componentClass.js)
    handler(builder)

    val el = if (addAsChild) child(builder.create()) else builder.create()

    // For some reason, we seem to need to add the children here whereas in the method above we don't...
    el.props.children

    return el
}

fun <P : StyledProps> StyledElementBuilder<P>.setStyledPropsAndRunHandler(
    className: String?,
    handler: StyledHandler<P>?
) {
    className?.let {
        attrs.className = it
    }

    if (handler != null) handler()
}