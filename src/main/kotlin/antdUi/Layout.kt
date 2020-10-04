package antdUi

import react.*
import styled.StyledHandler

@JsModule("antd")
@JsNonModule
private external val antdModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val layoutComponent: RComponent<UiLayoutProps, RState> = antdModule.Layout
@Suppress("UnsafeCastFromDynamic")
private val headerComponent: RComponent<UiHeaderProps, RState> = antdModule.Layout.Header
@Suppress("UnsafeCastFromDynamic")
private val siderComponent: RComponent<UiSiderProps, RState> = antdModule.Layout.Sider

fun RBuilder.uiLayout(
    addAsChild: Boolean = true,
    className: String? = null,
    handler: StyledHandler<UiLayoutProps>? = null
): ReactElement = createStyled(layoutComponent, addAsChild) {
    setStyledPropsAndRunHandler(className, handler)
}

fun RBuilder.uiHeader(
    addAsChild: Boolean = true,
    className: String? = null,
    handler: StyledHandler<UiHeaderProps>? = null
): ReactElement = createStyled(headerComponent, addAsChild) {
    setStyledPropsAndRunHandler(className, handler)
}

fun RBuilder.uiSider(
    addAsChild: Boolean = true,
    className: String? = null,
    handler: StyledHandler<UiSiderProps>? = null
): ReactElement = createStyled(siderComponent, addAsChild) {
    setStyledPropsAndRunHandler(className, handler)
}

external interface UiLayoutProps : UiBaseProps {

}

external interface UiHeaderProps : UiBaseProps {

}

external interface UiSiderProps : UiBaseProps {
    var width: String

}