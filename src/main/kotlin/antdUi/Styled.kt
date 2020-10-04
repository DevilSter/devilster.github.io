package antdUi

import react.*
import styled.StyledElementBuilder
import styled.StyledHandler
import styled.StyledProps
import kotlin.reflect.KClass

/**
 * Создаем styled (kotlin-styled) компоненты из обычных RComponent
 */
fun <P : StyledProps> RBuilder.createStyled(
    component: RComponent<P, RState>,
    addAsChild: Boolean = true,
    handler: StyledHandler<P>
): ReactElement {
    val builder = StyledElementBuilder<P>(component)
    handler(builder)
    return if (addAsChild) child(builder.create()) else builder.create()
}

/**
 * Создаем styled (kotlin-styled) компоненты из обычных RClass
 */
fun <P : StyledProps> RBuilder.createStyled(
    componentClass: KClass<out RComponent<P, RState>>,
    addAsChild: Boolean = true,
    handler: StyledHandler<P>
): ReactElement {
    val builder = StyledElementBuilder<P>(componentClass.js)
    handler(builder)

    val el = if (addAsChild) child(builder.create()) else builder.create()

    el.props.children

    return el
}

/**
 * Простой хелпер для установки имени класса и стилевых правил
 */
fun <P : StyledProps> StyledElementBuilder<P>.setStyledPropsAndRunHandler(
    className: String?,
    handler: StyledHandler<P>?
) {
    className?.let { attrs.className = it }
    if (handler != null) handler()
}