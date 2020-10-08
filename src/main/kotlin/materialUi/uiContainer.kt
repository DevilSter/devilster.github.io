package materialUi

import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler
import styled.StyledProps

@JsModule("@material-ui/core/Container")
@JsNonModule
private external val uiContainerModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val uiContainerComponent: RComponent<UiContainerProps, RState> = uiContainerModule.default

interface UiContainerProps : StyledProps {
    var component: String
    var disableGutters: Boolean
    var fixed: Boolean
    var maxWidth: Any
}

/**
 * Basic Container layout component.
 * Note: Setting maxWidth to null will disable maxWidth (i.e. pass false to underlying Material UI)
 */
fun RBuilder.uiContainer(
    maxWidth: UiBreakpoint? = UiBreakpoint.lg,
    fixed: Boolean = false,
    disableGutters: Boolean = false,
    component: String = "div",

    className: String? = null,
    handler: StyledHandler<UiContainerProps>? = null
) = createStyled(uiContainerComponent) {
    attrs.component = component
    attrs.disableGutters = disableGutters
    attrs.fixed = fixed
    attrs.maxWidth = maxWidth?.toString() ?: false

    setStyledPropsAndRunHandler(className, handler)
}