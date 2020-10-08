package materialUi

import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler


@JsModule("@material-ui/core/IconButton")
@JsNonModule
private external val iconButtonModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val iconButtonComponent: RComponent<UiIconButtonProps, RState> = iconButtonModule.default

@Suppress("EnumEntryName")
enum class MIconButtonSize {
    small, medium
}
@Suppress("EnumEntryName")
enum class UiIconEdge {
    start, end // We assume if the prop is null, then the default false will be used, so we don't have this as a value
}

interface UiIconButtonProps : UiButtonBaseProps {
    var disableFocusRipple: Boolean
    var href: String
}
var UiIconButtonProps.color by EnumPropToString(UiColors.values())
var UiIconButtonProps.edge by EnumPropToStringNullable(UiIconEdge.values())
var UiIconButtonProps.size by EnumPropToString(MIconButtonSize.values())

fun RBuilder.uiIconButton(
    iconName: String? = null,
    color: UiColors = UiColors.default,
    disabled: Boolean = false,
    onClick: ((Event) -> Unit)? = null,
    size: MIconButtonSize = MIconButtonSize.medium,
    hRefOptions: UiHRefOptions? = null,
    iconColor: UiIconColor? = null,
    edge: UiIconEdge? = null,

    addAsChild: Boolean = true,
    className: String? = null,
    handler: StyledHandler<UiIconButtonProps>? = null) = createStyled(iconButtonComponent, addAsChild) {
    attrs.color = color
    attrs.disabled = disabled
    edge?.let { attrs.edge = it }
    hRefOptions?.let { setHRefTargetNoOpener(attrs, it) }
    onClick?.let { attrs.onClick = onClick }

    var iconColorToUse = iconColor
    // If the iconColor is null, we shall map to the button color if we can
    if (iconColorToUse == null) {
        iconColorToUse = when (color) {
            UiColors.inherit -> UiIconColor.inherit
            UiColors.default -> UiIconColor.action
            UiColors.secondary -> UiIconColor.secondary
            UiColors.primary -> UiIconColor.primary
        }
    }
    attrs.size = size
    if (iconName != null) {
        val fontSize = when (size) {
            MIconButtonSize.small -> UiIconFontSize.small
            MIconButtonSize.medium -> UiIconFontSize.default
        }

        uiIcon(iconName, color = iconColorToUse, fontSize = fontSize)
    }

    setStyledPropsAndRunHandler(className, handler)
}
