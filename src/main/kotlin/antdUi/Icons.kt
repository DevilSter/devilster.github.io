package antdUi

import react.*
import styled.StyledHandler

@JsModule("@ant-design/icons")
@JsNonModule
private external val iconsModule: dynamic

@Suppress("UnsafeCastFromDynamic")
val UserOutlined: RComponent<UiBaseProps, RState> = iconsModule.UserOutlined

@Suppress("UnsafeCastFromDynamic")
val LaptopOutlined: RClass<RProps> = iconsModule.LaptopOutlined

@Suppress("UnsafeCastFromDynamic")
val NotificationOutlined: RClass<RProps> = iconsModule.NotificationOutlined

fun RBuilder.uiIconsUserOutlined(
    addAsChild: Boolean = true,
    className: String? = null,
    handler: StyledHandler<UiBaseProps>? = null
): ReactElement = createStyled(UserOutlined, addAsChild) {
    setStyledPropsAndRunHandler(className, handler)
}