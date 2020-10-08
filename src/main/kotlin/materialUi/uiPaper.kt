package materialUi

import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler
import styled.StyledProps


@JsModule("@material-ui/core/Paper")
@JsNonModule
private external val uiPaperModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val uiPaperComponent: RComponent<UiPaperProps, RState> = uiPaperModule.default

@Suppress("EnumEntryName")
enum class UiPaperVariant {
    elevation, outlined
}

interface UiPaperProps : StyledProps {
    var component: String
    var elevation: Int
    var square: Boolean
}
var UiPaperProps.variant by EnumPropToString(UiPaperVariant.values())

fun RBuilder.uiPaper(
    component: String = "div",
    elevation: Int = 2,
    square: Boolean = false,
    variant: UiPaperVariant = UiPaperVariant.elevation,

    className: String? = null,
    handler: StyledHandler<UiPaperProps>? = null) = createStyled(uiPaperComponent) {
    attrs.component = component
    attrs.elevation = elevation
    attrs.square = square
    attrs.variant = variant

    setStyledPropsAndRunHandler(className, handler)
}


