package materialUi

import kotlinx.css.flexGrow
import react.RBuilder
import react.RComponent
import react.RState
import react.ReactElement
import styled.StyledHandler
import styled.StyledProps
import styled.css

@JsModule("@material-ui/core/Toolbar")
@JsNonModule
private external val uiToolbarModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val uiToolbarComponent: RComponent<UiToolbarProps, RState> = uiToolbarModule.default

@Suppress("EnumEntryName")
enum class UiToolbarVariant {
    regular, dense
}

interface UiToolbarProps : StyledProps {
    var disableGutters: Boolean
    var component: String
}

var UiToolbarProps.variant by EnumPropToString(UiToolbarVariant.values())

fun RBuilder.uiToolbar(
    disableGutters: Boolean = false,
    variant: UiToolbarVariant = UiToolbarVariant.regular,

    className: String? = null,
    handler: StyledHandler<UiToolbarProps>? = null
) = createStyled(uiToolbarComponent) {
    attrs.disableGutters = disableGutters
    attrs.variant = variant

    setStyledPropsAndRunHandler(className, handler)
}

/**
 * Just a simple title with padding to push any items to the right, and no wrapping
 */
fun RBuilder.uiToolbarTitle(text: String): ReactElement {
    return uiTypography(
        text,
        variant = UiTypographyVariant.h6,
        color = UiTypographyColor.inherit,
        noWrap = true
    ) {
        css {
            flexGrow = 1.0
        }
    }
}