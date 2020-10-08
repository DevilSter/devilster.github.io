package materialUi

import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler


@JsModule("@material-ui/core/Link")
@JsNonModule
private external val uiLinkModule: dynamic
@Suppress("UnsafeCastFromDynamic")
private val uiLinkComponent: RComponent<UiLinkProps, RState> = uiLinkModule.default

@Suppress("EnumEntryName")
enum class UiLinkUnderline {
    none, hover, always
}

interface UiLinkProps : UiTypographyProps {
    var block: Boolean

    @JsName("TypographyClasses")
    var typographyClasses: String
}

var UiLinkProps.underline by EnumPropToString(UiLinkUnderline.values())


fun RBuilder.uiLink(
    text: String? = null,
    hRefOptions: UiHRefOptions? = null,
    underline: UiLinkUnderline = UiLinkUnderline.hover,
    gutterBottom: Boolean = false,
    noWrap: Boolean = false,

    className: String? = null,
    handler: StyledHandler<UiLinkProps>? = null
) = createStyled(uiLinkComponent) {
    attrs.gutterBottom = gutterBottom
    hRefOptions?.let { setHRefTargetNoOpener(attrs, it) }
    attrs.noWrap = noWrap
    attrs.underline = underline
    text?.let { childList.add(it) }

    setStyledPropsAndRunHandler(className, handler)
}

fun RBuilder.uiLink(
    text: String,
    hRef: String,
    underline: UiLinkUnderline = UiLinkUnderline.hover,
    gutterBottom: Boolean = false,
    noWrap: Boolean = false,

    className: String? = null,
    handler: StyledHandler<UiLinkProps>? = null
) = uiLink(
    text, UiHRefOptions(hRef), underline, gutterBottom,
    noWrap, className, handler
)
