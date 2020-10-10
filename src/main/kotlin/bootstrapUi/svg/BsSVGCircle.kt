package bootstrapUi.svg

import kotlinx.html.HTMLTag
import kotlinx.html.TagConsumer
import react.RBuilder
import react.ReactElement
import react.dom.tag

private class BsSVGCircle(initialAttrs: Map<String, String>, override val consumer: TagConsumer<*>) :
    HTMLTag("circle", consumer, initialAttrs, null, false, true) {}

fun RBuilder.bsSVGCircle(
    cx: Double,
    cy: Double,
    r: Double
): ReactElement = tag({}) {
    BsSVGCircle(
        mapOf(
            "cx" to cx.toString(),
            "cy" to cy.toString(),
            "r" to r.toString()
        ), it
    )
}