package materialUi

import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler
import styled.StyledProps


@JsModule("@material-ui/core/Hidden")
@JsNonModule
private external val uiHiddenModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val uiHiddenComponent: RComponent<UiHiddenProps, RState> = uiHiddenModule.default

@Suppress("EnumEntryName")
enum class UiHiddenImplementation {
    js, css
}

interface UiHiddenProps : StyledProps {
    var lgDown: Boolean
    var lgUp: Boolean
    var mdDown: Boolean
    var mdUp: Boolean
    var only: Array<UiBreakpoint>
    var smDown: Boolean
    var smUp: Boolean
    var xlDown: Boolean
    var xlUp: Boolean
    var xsDown: Boolean
    var xsUp: Boolean
}

var UiHiddenProps.initialWidth by EnumPropToStringNullable(UiBreakpoint.values())
var UiHiddenProps.implementation by EnumPropToString(UiHiddenImplementation.values())

fun RBuilder.uiHidden(
    only: Array<UiBreakpoint> = emptyArray(),
    xsUp: Boolean = false,
    smUp: Boolean = false,
    mdUp: Boolean = false,
    lgUp: Boolean = false,
    xlUp: Boolean = false,
    xsDown: Boolean = false,
    smDown: Boolean = false,
    mdDown: Boolean = false,
    lgDown: Boolean = false,
    xlDown: Boolean = false,
    className: String? = null,
    implementation: UiHiddenImplementation = UiHiddenImplementation.js,
    initialWidth: UiBreakpoint? = null,

    handler: StyledHandler<UiHiddenProps>
) = createStyled(uiHiddenComponent) {
    attrs.implementation = implementation
    initialWidth?.let { attrs.initialWidth = it }
    attrs.lgDown = lgDown
    attrs.lgUp = lgUp
    attrs.mdDown = mdDown
    attrs.mdUp = mdUp
    attrs.only = only
    attrs.smDown = smDown
    attrs.smUp = smUp
    attrs.xlDown = xlDown
    attrs.xlUp = xlUp
    attrs.xsDown = xsDown
    attrs.xsUp = xsUp

    setStyledPropsAndRunHandler(className, handler)
}



