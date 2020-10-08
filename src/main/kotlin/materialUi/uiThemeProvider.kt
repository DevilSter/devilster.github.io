package materialUi

import kotlinx.css.LinearDimension
import react.*
import kotlinx.css.px

private val themeOptions: UiThemeOptions = js("({typography: {useNextVariants: true}})").unsafeCast<UiThemeOptions>()
private var defaultTheme: UiTheme = createMaterialUiTheme(themeOptions)


@JsModule("@material-ui/core/styles")
@JsNonModule
private external val materialThemeProviderModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val materialThemeProviderComponent: RComponent<UiThemeProviderProps, RState> =
    materialThemeProviderModule.ThemeProvider

interface UiThemeProviderProps : RProps {
    var disableStylesGeneration: Boolean
    var sheetsManager: Any
    var theme: UiTheme
}

fun RBuilder.uiThemeProvider(
    theme: UiTheme, disableStylesGeneration: Boolean? = null, sheetsManager: Any? = null,
    handler: RHandler<UiThemeProviderProps>? = null
) = child(materialThemeProviderComponent) {
    disableStylesGeneration?.let { attrs.disableStylesGeneration = disableStylesGeneration }
    sheetsManager?.let { attrs.sheetsManager = sheetsManager }
    attrs.theme = theme

    if (handler != null) handler()
}

val themeContext = createContext(defaultTheme)

val Int.spacingUnits
    get() = (defaultTheme.spacing(this)).px

class UiThemeProvider(props: UiThemeProviderProps) : RComponent<UiThemeProviderProps, RState>(props) {
    override fun RBuilder.render() {
        @Suppress("DEPRECATION")
        uiThemeProvider(props.theme) {
            themeContext.Provider(props.theme) {
                children()
            }
        }
    }
}