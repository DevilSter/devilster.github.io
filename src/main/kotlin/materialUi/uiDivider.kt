package materialUi

import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler
import styled.StyledProps


@JsModule("@material-ui/core/Divider")
@JsNonModule
private external val uiDividerModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val uiDividerComponent: RComponent<UiDividerProps, RState> = uiDividerModule.default

@Suppress("EnumEntryName")
enum class UiDividerOrientation {
    horizontal, vertical
}

@Suppress("EnumEntryName")
enum class UiDividerVariant {
    fullWidth, inset, middle
}

interface UiDividerProps : StyledProps {
    var absolute: Boolean
    var component: String
    var light: Boolean
}

var UiDividerProps.orientation by EnumPropToString(UiDividerOrientation.values())
var UiDividerProps.variant by EnumPropToString(UiDividerVariant.values())

fun RBuilder.uiDivider(
    variant: UiDividerVariant = UiDividerVariant.fullWidth,
    light: Boolean = false,
    absolute: Boolean = false,
    orientation: UiDividerOrientation = UiDividerOrientation.horizontal,
    component: String = "hr",

    addAsChild: Boolean = true,
    className: String? = null,
    handler: StyledHandler<UiDividerProps>? = null
) = createStyled(uiDividerComponent, addAsChild) {
    attrs.absolute = absolute
    attrs.component = component
    attrs.light = light
    attrs.orientation = orientation
    attrs.variant = variant

    setStyledPropsAndRunHandler(className, handler)
}

