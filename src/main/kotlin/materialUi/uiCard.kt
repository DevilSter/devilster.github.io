package materialUi

import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler
import styled.StyledProps


@JsModule("@material-ui/core/Card")
@JsNonModule
private external val uiCardModule: dynamic

@JsModule("@material-ui/core/CardContent")
@JsNonModule
private external val uiCardContentModule: dynamic

@JsModule("@material-ui/core/CardActionArea")
@JsNonModule
private external val uiCardActionAreaModule: dynamic

@JsModule("@material-ui/core/CardMedia")
@JsNonModule
private external val uiCardMediaModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val uiCardComponent: RComponent<UiCardProps, RState> = uiCardModule.default

@Suppress("UnsafeCastFromDynamic")
private val uiCardContentComponent: RComponent<UiCardContentProps, RState> = uiCardContentModule.default

@Suppress("UnsafeCastFromDynamic")
private val uiCardActionAreaComponent: RComponent<UiCardActionArea, RState> = uiCardActionAreaModule.default

@Suppress("UnsafeCastFromDynamic")
private val uiCardMediaComponent: RComponent<UiCardMediaProps, RState> = uiCardMediaModule.default


external interface UiCardProps : StyledProps {
    var raised: Boolean
}

external interface UiCardContentProps : StyledProps {
    var component: String
}

external interface UiCardActionArea : UiButtonBaseProps {
    var href: String
}

external interface UiCardMediaProps : StyledProps {
    var component: String
    var image: String
    var title: String
}

fun RBuilder.uiCard(
    raised: Boolean = false,
    className: String? = null,
    handler: StyledHandler<UiCardProps>? = null
) = createStyled(uiCardComponent) {
    attrs.raised = raised

    setStyledPropsAndRunHandler(className, handler)
}

fun RBuilder.uiCardContent(
    className: String? = null,
    handler: StyledHandler<UiCardContentProps>? = null
) = createStyled(uiCardContentComponent) {
    setStyledPropsAndRunHandler(className, handler)
}

fun RBuilder.uiCardActionArea(
    onClick: ((Event) -> Unit)? = null,
    disabled: Boolean = false,

    className: String? = null,
    handler: StyledHandler<UiCardActionArea>? = null
) = createStyled(uiCardActionAreaComponent) {
    attrs.disabled = disabled
    onClick?.let { attrs.onClick = onClick }

    setStyledPropsAndRunHandler(className, handler)
}

fun RBuilder.uiCardMedia(
    image: String,
    title: String = "",
    className: String? = null,
    handler: StyledHandler<UiCardMediaProps>? = null
) = createStyled(uiCardMediaComponent) {
    attrs.image = image
    attrs.title = title
    setStyledPropsAndRunHandler(className, handler)
}