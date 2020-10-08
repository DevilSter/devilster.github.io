package materialUi

import kotlinext.js.jsObject
import react.RProps
import kotlin.text.Typography

external interface UiThemeOptions {
    var shape: UiShapeOptions
    var breakpoints: UiBreakpoints
    var direction: dynamic
        get() = definedExternally
        set(value) = definedExternally
    var mixins: dynamic
    var overrides: dynamic
    var palette: UiPaletteOptions?
        get() = definedExternally
        set(value) = definedExternally
    var props: RProps
    var shadows: dynamic
    var spacing: dynamic
    var transitions: UiTransitionsOptions?
        get() = definedExternally
        set(value) = definedExternally
    var typography: UiTypographyOptions?
        get() = definedExternally
        set(value) = definedExternally
    var zIndex: dynamic
}

external interface UiTheme {
    var shape: UiShapeOptions
    var breakpoints: UiBreakpoints
    var direction: dynamic /* String /* "ltr" */ | String /* "rtl" */ */
    var mixins: UiMixins
    var overrides: dynamic
    var palette: UiPalette
    var props: RProps
    var shadows: dynamic
    var spacing: UiSpacing
    var transitions: UiTransitions
    var typography: Typography
    var zIndex: UiZIndex
}

@JsModule("@material-ui/core/styles/createMuiTheme")
@JsNonModule
private external val createMaterialUiThemeModule: dynamic

@Suppress("UnsafeCastFromDynamic")
fun createMaterialUiTheme(themeOptions: UiThemeOptions? = null, typographyWarningsOff: Boolean = true): UiTheme {
    val ourThemeOptions = themeOptions ?: jsObject {}

    if (typographyWarningsOff) {
        if (ourThemeOptions.typography == undefined) {
            ourThemeOptions.typography = jsObject {}
        }

        ourThemeOptions.typography?.useNextVariants = true
    }
    return createMaterialUiThemeModule.default(ourThemeOptions)
}