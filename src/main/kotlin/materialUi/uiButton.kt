package materialUi

import org.w3c.dom.events.Event
import react.*
import styled.StyledHandler


@JsModule("@material-ui/core/Button")
@JsNonModule
private external val uiButtonModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val uiButtonComponent: RComponent<UiButtonProps, RState> = uiButtonModule.default

interface UiButtonProps : UiButtonBaseProps {
    var disableFocusRipple: Boolean
    var disableElevation: Boolean
    var endIcon: ReactElement
    var fullWidth: Boolean
    var href: String
    var startIcon: ReactElement
}

var UiButtonProps.color by EnumPropToString(UiColors.values())
var UiButtonProps.size by EnumPropToString(UiButtonSize.values())
var UiButtonProps.variant by EnumPropToStringNullable(UiButtonVariant.values())


//Setting the color and variant to the default values seems to upset button groups... the buttons don't inherit the
//groups color or variant, even if color is default... so allowing color and variant to default to null which seems
//to fix the issue and does not cause any issues
fun RBuilder.uiButton(
    caption: String,
    color: UiColors = UiColors.default,
    variant: UiButtonVariant? = null,
    disabled: Boolean = false,
    onClick: ((Event) -> Unit)? = null,
    size: UiButtonSize = UiButtonSize.medium,
    hRefOptions: UiHRefOptions? = null,

    addAsChild: Boolean = true,
    className: String? = null,
    handler: StyledHandler<UiButtonProps>? = null
) = createStyled(uiButtonComponent, addAsChild) {
    attrs.color = color
    attrs.disabled = disabled
    hRefOptions?.let { setHRefTargetNoOpener(attrs, it) }
    onClick?.let { attrs.onClick = onClick }
    attrs.size = size
    attrs.variant = variant

    childList.add(caption)

    setStyledPropsAndRunHandler(className, handler)
}

external interface UiButtonBaseProps : UiStyledPropsWithCommonAttributes {
    var centerRipple: Boolean
    var component: String
    var disabled: Boolean
    var disableRipple: Boolean
    var focusRipple: Boolean
    var onKeyboardFocus: (Event) -> Unit

    @JsName("TouchRippleProps")
    var touchRippleProps: RProps?
}

@Suppress("EnumEntryName")
enum class UiButtonSize {
    small, medium, large
}

@Suppress("EnumEntryName")
enum class UiButtonVariant {
    text, outlined, contained
}