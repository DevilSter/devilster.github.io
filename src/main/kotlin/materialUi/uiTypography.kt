package materialUi

import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler

@JsModule("@material-ui/core/Typography")
@JsNonModule
private external val uiTypographyDefault: dynamic

@Suppress("UnsafeCastFromDynamic")
private val uiTypographyComponent: RComponent<UiTypographyProps, RState> = uiTypographyDefault.default

@Suppress("EnumEntryName")
enum class UiTypographyAlign {
    inherit, left, center, right, justify
}

@Suppress("EnumEntryName")
enum class UiTypographyColor {
    initial, inherit, primary, secondary, textPrimary, textSecondary, error
}

@Suppress("EnumEntryName")
enum class UiTypographyVariant {
    h1, h2, h3, h4, h5, h6, subtitle1, subtitle2, body1, body2, caption, button, overline, srOnly, inherit
}

interface UiTypographyProps : UiStyledPropsWithCommonAttributes {
    var component: String
    var gutterBottom: Boolean
    var noWrap: Boolean
    var paragraph: Boolean
}

var UiTypographyProps.align by EnumPropToString(UiTypographyAlign.values())
var UiTypographyProps.color by EnumPropToString(UiTypographyColor.values())
var UiTypographyProps.variant by EnumPropToString(UiTypographyVariant.values())


fun RBuilder.uiTypography(
    text: String? = null,
    variant: UiTypographyVariant = UiTypographyVariant.body1,
    color: UiTypographyColor = UiTypographyColor.initial,
    align: UiTypographyAlign = UiTypographyAlign.left,
    gutterBottom: Boolean = false,
    noWrap: Boolean = false,
    paragraph: Boolean = false,
    component: String? = null,

    addAsChild: Boolean = true,
    className: String? = null,
    handler: StyledHandler<UiTypographyProps>? = null
) = createStyled(uiTypographyComponent, addAsChild) {
    attrs.align = align
    attrs.color = color
    component?.let { attrs.component = it }
    attrs.gutterBottom = gutterBottom
    attrs.noWrap = noWrap
    attrs.paragraph = paragraph
    attrs.variant = variant

    text?.let { childList.add(it) }

    setStyledPropsAndRunHandler(className, handler)
}
