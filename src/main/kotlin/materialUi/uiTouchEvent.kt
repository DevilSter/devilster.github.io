package materialUi

import org.w3c.dom.Element
import org.w3c.dom.events.UIEvent
import org.w3c.dom.events.UIEventInit


/**
 * Exposes the JavaScript [TouchEvent](https://developer.mozilla.org/en/docs/Web/API/TouchEvent) to Kotlin
 */
open external class UiTouchEvent(type: String, eventInitDict: UiTouchEventInit = definedExternally) : UIEvent {
    open val altKey: Boolean
    open val changedTouches: Array<Touch>
    open val ctrlKey: Boolean
    open val metaKey: Boolean
    open val shiftKey: Boolean
    open val targetTouchesRead: Array<Touch>
    open val touches: Array<Touch>
    open val rotation: Double
    open val scale: Double
}

external interface UiTouchEventInit : UIEventInit {
    var altKey: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var changedTouches: Array<Touch>?
        get() = definedExternally
        set(value) = definedExternally
    var ctrlKey: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var metaKey: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var shiftKey: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var targetTouchesRead: Array<Touch>?
        get() = definedExternally
        set(value) = definedExternally
    var touches: Array<Touch>?
        get() = definedExternally
        set(value) = definedExternally
    var rotation: Double?
        get() = definedExternally
        set(value) = definedExternally
    var scale: Double?
        get() = definedExternally
        set(value) = definedExternally
}

interface Touch {
    var identifier: Long
    var screenX: Int
    var screenY: Int
    var clientX: Long
    var clientY: Long
    var pageX: Double
    var pageY: Double
    var target: Element
}