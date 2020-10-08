package materialUi

import kotlinext.js.Object
import org.w3c.dom.Element
import react.*

@JsModule("@material-ui/styles/StylesProvider")
@JsNonModule
private external val stylesProviderModule: dynamic

@Suppress("UnsafeCastFromDynamic")
val stylesProviderComponent: RComponent<MStylesProviderProps, RState> = stylesProviderModule.default

@JsModule("@material-ui/styles/jssPreset")
@JsNonModule
private external val jssPresetModule: dynamic

@JsModule("jss")
@JsNonModule
private external val jss: dynamic


interface MStylesProviderProps : RProps {
    var disableGeneration: Boolean
    var generateClassName: () -> Unit
    var injectFirst: Boolean
    var jss: Object
}

fun RBuilder.uiStylesProvider(
    injectFirst: Boolean = false,
    disableGeneration: Boolean = false,
    generateClassName: (() -> Unit)? = null,
    jss: Object? = null,
    handler: RHandler<MStylesProviderProps>? = null
) = child(stylesProviderComponent) {
    attrs.injectFirst = injectFirst
    attrs.disableGeneration = disableGeneration
    generateClassName?.let { attrs.generateClassName = it }
    jss?.let { attrs.jss = it }

    handler?.let { it() }
}

fun RBuilder.uiStylesProvider(
    insertionPointComment: String,
    handler: RHandler<MStylesProviderProps>? = null
): ReactElement {

    val jssPresets = jssPresetModule.default()
    jssPresets.insertionPoint = insertionPointComment

    val jss = jss.create(jssPresets)

    return uiStylesProvider(
        injectFirst = false,
        disableGeneration = false,
        generateClassName = null,
        jss = jss as? Object,
        handler = handler
    )
}

fun RBuilder.uiStylesProvider(
    insertionPointElement: Element,
    handler: RHandler<MStylesProviderProps>? = null
): ReactElement {

    val jssPresets = jssPresetModule.default()
    jssPresets.insertionPoint = insertionPointElement

    val jss = jss.create(jssPresets)

    return uiStylesProvider(
        injectFirst = false,
        disableGeneration = false,
        generateClassName = null,
        jss = jss as? Object,
        handler = handler
    )
}