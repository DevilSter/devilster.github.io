package antdUi

import react.RBuilder
import react.RComponent
import react.RState
import react.ReactElement
import styled.StyledHandler

@JsModule("antd")
@JsNonModule
private external val antdModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val menuComponent: RComponent<UiMenuProps, RState> = antdModule.Menu
@Suppress("UnsafeCastFromDynamic")
private val menuItemComponent: RComponent<UiMenuItemProps, RState> = antdModule.Menu.Item
@Suppress("UnsafeCastFromDynamic")
private val subMenuComponent: RComponent<UiSubmenuProps, RState> = antdModule.Menu.SubMenu

fun RBuilder.uiMenu(
    addAsChild: Boolean = true,
    className: String? = null,
    handler: StyledHandler<UiMenuProps>? = null
): ReactElement = createStyled(menuComponent, addAsChild) {
    setStyledPropsAndRunHandler(className, handler)
}

fun RBuilder.uiMenuItem(
    addAsChild: Boolean = true,
    className: String? = null,
    handler: StyledHandler<UiMenuItemProps>? = null
): ReactElement = createStyled(menuItemComponent, addAsChild) {
    setStyledPropsAndRunHandler(className, handler)
}

fun RBuilder.uiSubmenu(
    addAsChild: Boolean = true,
    className: String? = null,
    handler: StyledHandler<UiSubmenuProps>? = null
): ReactElement = createStyled(subMenuComponent, addAsChild) {
    setStyledPropsAndRunHandler(className, handler)
}

external interface UiMenuProps : UiBaseProps {
    var theme: String
    var mode: String
    var defaultSelectedKeys: dynamic
    var defaultOpenKeys: dynamic
}

external interface UiMenuItemProps : UiBaseProps {

}

external interface UiSubmenuProps : UiBaseProps {
    var title: String
    var icon: dynamic
}
