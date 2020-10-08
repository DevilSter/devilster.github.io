package materialUi

external interface UiShapeOptions {
    var borderRadius: Int
}

@Suppress("EnumEntryName")
enum class UiBreakpoint {
    xs, sm, md, lg, xl
}

external interface UiCommonColors {
    var black: String
    var white: String
}

external interface UiColor {
    var _50: String
    var _100: String
    var _200: String
    var _300: String
    var _400: String
    var _500: String
    var _600: String
    var _700: String
    var _800: String
    var _900: String
    var A100: String
    var A200: String
    var A400: String
    var A700: String
}

external interface UiTypeText {
    var primary: String
    var secondary: String
    var disabled: String
    var hint: String
}

external interface UiTypeAction {
    var active: String
    var hover: String
    var selected: String
    var disabled: String
    var disabledBackground: String
}

external interface UiTypeBackground {
    var default: String
    var paper: String
}

external interface UiPaletteColor {
    var light: String
    var main: String
    var dark: String
    var contrastText: String
}

external interface UiPalette {
    var common: UiCommonColors
    var type: String //export type PaletteType = 'light' | 'dark';
    var contrastThreshold: Int
    var tonalOffset: Float
    var primary: UiPaletteColor
    var secondary: UiPaletteColor
    var error: UiPaletteColor
    var grey: UiColor
    var text: UiTypeText
    var divider: String
    var action: UiTypeAction
    var background: UiTypeBackground
    var getContrastText: (color: String) -> String
}

external interface UiPaletteOptions {
    var common: Any?
        get() = definedExternally
        set(value) = definedExternally
    var type: String?
        get() = definedExternally;
        set(value) = definedExternally
    var primary: dynamic
        get() = definedExternally
        set(value) = definedExternally
    var secondary: dynamic
        get() = definedExternally
        set(value) = definedExternally
    var error: dynamic
        get() = definedExternally
        set(value) = definedExternally
    var grey: Any?
        get() = definedExternally
        set(value) = definedExternally
    var text: Any?
        get() = definedExternally
        set(value) = definedExternally
    var divider: String?
        get() = definedExternally
        set(value) = definedExternally
    var action: Any?
        get() = definedExternally
        set(value) = definedExternally
    var background: Any?
        get() = definedExternally
        set(value) = definedExternally
    var getContrastText: ((color: String) -> String)?
        get() = definedExternally
        set(value) = definedExternally
}

external interface UiTransitionsOptions {
    var easing: Any?
        get() = definedExternally
        set(value) = definedExternally
    var duration: Any?
        get() = definedExternally
        set(value) = definedExternally
    var create: ((props: dynamic, options: Any?) -> String)?
        get() = definedExternally
        set(value) = definedExternally
    var getAutoHeightDuration: ((height: Int) -> Int)?
        get() = definedExternally
        set(value) = definedExternally
}

external interface UiEasing {
    var easeInOut: String
    var easeOut: String
    var easeIn: String
    var sharp: String
}

external interface UiDuration {
    var shortest: Int
    var shorter: Int
    var short: Int
    var standard: Int
    var complex: Int
    var enteringScreen: Int
    var leavingScreen: Int
}

external interface UiTransitions {
    var easing: UiEasing
    var duration: UiDuration
    fun create(props: String, options: Any? = definedExternally): String
    fun create(props: Array<String>, options: Any? = definedExternally): String
    fun getAutoHeightDuration(height: Number): Int
}

external interface UiFontStyle {
    var fontFamily: String?
    var fontSize: Int
    var fontWeightLight: Int
    var fontWeightRegular: Int
    var fontWeightMedium: Int
    var fontWeightBold: Int
    var htmlFontSize: Int?
}

external interface UiTypographyStyle {
    var color: String?
    var fontFamily: String?
    var fontSize: Int
    var fontWeight: Int
    var letterSpacing: String?
    var lineHeight: String?
    var textTransform: String?

    // From FontStyleOptions
    var useNextVariants: Boolean?
}

external interface UiTypography : UiFontStyle, UiTypographyStyle {
    var h1: UiTypographyStyle
    var h2: UiTypographyStyle
    var h3: UiTypographyStyle
    var h4: UiTypographyStyle
    var h5: UiTypographyStyle
    var h6: UiTypographyStyle
    var subtitle1: UiTypographyStyle
    var subtitle2: UiTypographyStyle
    var body1: UiTypographyStyle
    var body2: UiTypographyStyle
    var caption: UiTypographyStyle
    var button: UiTypographyStyle
    var overline: UiTypographyStyle
}

external interface UiTypographyOptions : UiTypography

/**
 * The js up, down, etc calls all return a string beginning with "@media". We usually use these functions in
 * css { media {...} } calls (e.g. media(currentTheme.breakpoints.up(Breakpoint.md)) ), so we don't need the
 * "@media" prefix as css { media {...} } adds the prefix as well.
 *
 * Also note that we are using String keys in the js calls as for some calls using the breakpoint value compiles and
 * runs, but returns nonsense values... so not sure what is getting called there, but calling with a string works.
 */
external interface UiBreakpoints {
    var keys: Array<UiBreakpoint>

    @JsName("up")
    fun upWithMediaTerm(key: String): String

    @JsName("up")
    fun upWithMediaTerm(key: Int): String

    @JsName("down")
    fun downWithMediaTerm(key: String): String

    @JsName("down")
    fun downWithMediaTerm(key: Int): String

    @JsName("between")
    fun betweenWithMediaTerm(start: String, end: String): String

    @JsName("only")
    fun onlyWithMediaTerm(key: String): String

    @JsName("width")
    fun widthWithStringKey(key: String): Int
}

private fun removeMediaString(query: String) = if (query.startsWith("@media")) query.substring(6) else query

fun UiBreakpoints.up(key: UiBreakpoint): String {
    return removeMediaString(upWithMediaTerm(key.toString()))
}

fun UiBreakpoints.down(key: UiBreakpoint): String {
    return removeMediaString(downWithMediaTerm(key.toString()))
}

fun UiBreakpoints.between(startKey: UiBreakpoint, endKey: UiBreakpoint): String {
    return removeMediaString(betweenWithMediaTerm(startKey.toString(), endKey.toString()))
}

fun UiBreakpoints.only(key: UiBreakpoint): String {
    return removeMediaString(onlyWithMediaTerm(key.toString()))
}

fun UiBreakpoints.width(key: UiBreakpoint): Int {
    return widthWithStringKey(key.toString())
}

external interface UiMixins {
    var gutters: dynamic
    var toolbar: dynamic
}

external interface UiSpacing

@Suppress("NOTHING_TO_INLINE")
inline operator fun UiSpacing.invoke(): Number {
    return asDynamic()().unsafeCast<Number>()
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun UiSpacing.invoke(value1: Number): Number {
    return asDynamic()(value1).unsafeCast<Number>()
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun UiSpacing.invoke(value1: Number, value2: Number): String {
    return asDynamic()(value1, value2).unsafeCast<String>()
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun UiSpacing.invoke(value1: Number, value2: Number, value3: Number): String {
    return asDynamic()(value1, value2, value3).unsafeCast<String>()
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun UiSpacing.invoke(value1: Number, value2: Number, value3: Number, value4: Number): String {
    return asDynamic()(value1, value2, value3, value4).unsafeCast<String>()
}

external interface UiZIndex {
    var mobileStepper: Int
    var appBar: Int
    var drawer: Int
    var modal: Int
    var snackbar: Int
    var tooltip: Int
}