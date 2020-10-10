package bootstrapUi.svg

import kotlinx.html.HTMLTag
import kotlinx.html.TagConsumer
import react.RBuilder
import react.ReactElement
import react.dom.tag

private class BsSVGPath(initialAttrs: Map<String, String>, override val consumer: TagConsumer<*>) :
    HTMLTag("path", consumer, initialAttrs, null, false, true) {}

fun RBuilder.bsSVGPath(d: String): ReactElement = tag({}) {
    BsSVGPath(mapOf("d" to d), it)
}