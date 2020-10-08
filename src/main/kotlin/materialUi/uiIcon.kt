package materialUi

import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler
import styled.StyledProps

@JsModule("@material-ui/core/Icon")
@JsNonModule
private external val uiIconModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val uiIconComponent: RComponent<UiIconProps, RState> = uiIconModule.default

@Suppress("EnumEntryName")
enum class UiIconColor {
    inherit, primary, secondary, action, error, disabled
}

@Suppress("EnumEntryName")
enum class UiIconFontSize {
    inherit, default, small, large
}

interface UiIconProps : StyledProps {
    var component: String?
}

var UiIconProps.color by EnumPropToString(UiIconColor.values())
var UiIconProps.fontSize by EnumPropToString(UiIconFontSize.values())

fun RBuilder.uiIcon(
    iconName: String,
    color: UiIconColor = UiIconColor.inherit,
    fontSize: UiIconFontSize = UiIconFontSize.default,

    addAsChild: Boolean = true,
    className: String? = null,
    handler: StyledHandler<UiIconProps>? = null
) = createStyled(uiIconComponent, addAsChild) {
    attrs.color = color
    attrs.fontSize = fontSize

    childList.add(iconName)
    setStyledPropsAndRunHandler(className, handler)
}


