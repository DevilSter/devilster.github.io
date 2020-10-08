package materialUi

import kotlinext.js.jsObject
import react.*
import styled.StyledElementBuilder
import styled.StyledHandler
import styled.StyledProps
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

/**
 * Просто делаем чайлда без пропсов. Ничего больше
 */
fun <P : RProps, S : RState> RBuilder.child(component: RComponent<P, S>, handler: RHandler<P>): ReactElement {
    val props: P = jsObject {}
    return child(component, props, handler)
}

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
    className?.let { attrs.className = it }
    if (handler != null) handler()
}

class EnumPropToString<T>(
    private val enumValues: Array<T>,
    private val propNameOverride: String? = null,
    private val childProp: String? = null
) : ReadWriteProperty<RProps, T> {
    override fun getValue(thisRef: RProps, property: KProperty<*>): T {
        val valAsString = valueAsString(property, thisRef, propNameOverride, childProp)
        return enumValues.first { it.toString() == valAsString }
    }

    override fun setValue(thisRef: RProps, property: KProperty<*>, value: T) {
        val propName = propNameOverride ?: property.name

        if (childProp == null) {
            thisRef.asDynamic()[propName] = value.toString()
        } else {
            if (thisRef.asDynamic()[propName] == undefined) {
                thisRef.asDynamic()[propName] = js("({})")
            }
            thisRef.asDynamic()[propName][childProp] = value.toString()
        }
    }
}

class EnumPropToStringNullable<T>(
    private val enumValues: Array<T>,
    private val propNameOverride: String? = null,
    private val childProp: String? = null
) : ReadWriteProperty<RProps, T?> {
    override fun getValue(thisRef: RProps, property: KProperty<*>): T? {
        val valAsString = valueAsString(property, thisRef, propNameOverride, childProp)

        return if (valAsString != null) {
            enumValues.firstOrNull { it.toString() == valAsString }
        } else {
            null
        }
    }

    override fun setValue(thisRef: RProps, property: KProperty<*>, value: T?) {
        val propName = propNameOverride ?: property.name

        if (childProp == null) {
            thisRef.asDynamic()[propName] = value?.toString()
        } else {
            if (thisRef.asDynamic()[propName] == undefined) {
                thisRef.asDynamic()[propName] = js("({})")
            }
            thisRef.asDynamic()[propName][childProp] = value?.toString()
        }
    }
}

private fun valueAsString(
    property: KProperty<*>,
    thisRef: RProps,
    propNameOverride: String?,
    childProp: String?
): String? {
    val propName = propNameOverride ?: property.name

    return if (childProp == null) {
        if (thisRef.asDynamic()[propName] is String) {
            thisRef.asDynamic()[propName] as String?
        } else {
            null
        }
    } else {
        if (thisRef.asDynamic()[propName] != undefined) {
            if (thisRef.asDynamic()[propName][childProp] is String) {
                thisRef.asDynamic()[propName][childProp] as String?
            } else {
                null
            }
        } else {
            null
        }
    }
}

@Suppress("EnumEntryName")
enum class UiColors {
    default, inherit, primary, secondary
}

data class UiHRefOptions(val href: String, val targetBlank: Boolean = true, val target: String? = "")

fun setHRefTargetNoOpener(attrs: RProps, hRefOptions: UiHRefOptions) {
    setHRefTargetNoOpener(attrs, hRefOptions.href, hRefOptions.targetBlank, hRefOptions.target)
}

fun setHRefTargetNoOpener(attrs: RProps, href: String?, targetBlank: Boolean, target: String?) {
    href?.let { it ->
        attrs.asDynamic().href = it

        target?.let { attrs.asDynamic().target = it }
        // We have not got a prop for target, so we will let a parent element sort it.

        if (targetBlank) {
            attrs.asDynamic().target = "_blank"
            attrs.asDynamic().rel = "noopener"
        }
    }
}

typealias SimpleEvent = () -> Unit

fun String.toHyphenCase(): String {
    var text = ""
    var isFirst = true
    this.forEach {
        if (it in 'A'..'Z') {
            if (!isFirst) text += "-"
            text += it.toLowerCase()
        } else {
            text += it
        }
        isFirst = false
    }
    return text
}