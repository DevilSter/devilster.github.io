package antdUi

import react.*
import styled.StyledHandler
import styled.StyledProps

@JsModule("antd")
@JsNonModule
private external val antdModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val buttonComponent: RComponent<UiButtonProps, RState> = antdModule.Button

fun RBuilder.uiButton(
    caption: String,
    addAsChild: Boolean = true,
    className: String? = null,
    handler: StyledHandler<UiButtonProps>? = null
): ReactElement = createStyled(buttonComponent, addAsChild) {
    childList.add(caption)

    setStyledPropsAndRunHandler(className, handler)
}

external interface UiButtonProps : RProps, StyledProps {
    var type: String
    var onClick: () -> dynamic
}

