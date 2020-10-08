package materialUi

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import styled.StyledHandler
import styled.StyledProps
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


@JsModule("@material-ui/core/Grid")
@JsNonModule
private external val uiGridDefault: dynamic

@Suppress("UnsafeCastFromDynamic")
private val uiGridComponent: RComponent<UiGridProps, RState> = uiGridDefault.default

@Suppress("EnumEntryName")
enum class UiGridAlignContent {
    stretch,
    center,
    flexStart,
    flexEnd,
    spaceBetween,
    spaceAround;

    override fun toString(): String {
        return super.toString().toHyphenCase()
    }
}

@Suppress("EnumEntryName")
enum class UiGridAlignItems {
    stretch,
    center,
    flexStart,
    flexEnd,
    baseline;

    override fun toString(): String {
        return super.toString().toHyphenCase()
    }
}

@Suppress("EnumEntryName")
enum class UiGridDirection {
    row,
    rowReverse,
    column,
    columnReverse;

    override fun toString(): String {
        return super.toString().toHyphenCase()
    }
}

@Suppress("EnumEntryName")
enum class MGridJustify {
    flexStart,
    center,
    flexEnd,
    spaceBetween,
    spaceAround;

    override fun toString(): String {
        return super.toString().toHyphenCase()
    }
}

@Suppress("EnumEntryName")
enum class UiGridSize(internal val sizeVal: Any) {
    cellsFalse(false),
    cellsAuto("auto"),
    cellsTrue(true),
    cells1(1),
    cells2(2),
    cells3(3),
    cells4(4),
    cells5(5),
    cells6(6),
    cells7(7),
    cells8(8),
    cells9(9),
    cells10(10),
    cells11(11),
    cells12(12);
}

@Suppress("EnumEntryName")
enum class UiGridWrap {
    noWrap, wrap, wrapReverse;

    override fun toString(): String {
        return when (this) {
            noWrap -> "nowrap"
            wrap -> "wrap"
            wrapReverse -> "wrap-reverse"
        }
    }
}

@Suppress("EnumEntryName")
enum class UiGridSpacing(internal val size: Int) {
    spacing0(0),
    spacing1(1),
    spacing2(2),
    spacing3(3),
    spacing4(4),
    spacing5(5),
    spacing6(6),
    spacing7(7),
    spacing8(8),
    spacing9(9),
    spacing10(10)
}

/**
 * This class as no companion in MaterialUI. We just use it to make setting grid breakpoints a bit easier
 */
data class UiGridBreakpoints(
    val xs: UiGridSize = UiGridSize.cellsAuto,
    val sm: UiGridSize = UiGridSize.cellsAuto,
    val md: UiGridSize = UiGridSize.cellsAuto,
    val lg: UiGridSize = UiGridSize.cellsAuto,
    val xl: UiGridSize = UiGridSize.cellsAuto
) {
    constructor(defaultGridSize: UiGridSize) : this(
        defaultGridSize,
        defaultGridSize,
        defaultGridSize,
        defaultGridSize,
        defaultGridSize
    )

    fun down(breakpoint: UiBreakpoint, gridSize: UiGridSize): UiGridBreakpoints {
        return when (breakpoint) {
            UiBreakpoint.xs -> copy(xs = gridSize)
            UiBreakpoint.sm -> copy(xs = gridSize, sm = gridSize)
            UiBreakpoint.md -> copy(xs = gridSize, sm = gridSize, md = gridSize)
            UiBreakpoint.lg -> copy(xs = gridSize, sm = gridSize, md = gridSize, lg = gridSize)
            UiBreakpoint.xl -> copy(xs = gridSize, sm = gridSize, md = gridSize, lg = gridSize, xl = gridSize)
        }
    }

    fun up(breakpoint: UiBreakpoint, gridSize: UiGridSize): UiGridBreakpoints {
        return when (breakpoint) {
            UiBreakpoint.xs -> copy(xl = gridSize, lg = gridSize, md = gridSize, sm = gridSize, xs = gridSize)
            UiBreakpoint.sm -> copy(xl = gridSize, lg = gridSize, md = gridSize, sm = gridSize)
            UiBreakpoint.md -> copy(xl = gridSize, lg = gridSize, md = gridSize)
            UiBreakpoint.lg -> copy(xl = gridSize, lg = gridSize)
            UiBreakpoint.xl -> copy(xl = gridSize)
        }
    }
}


interface UiGridProps : StyledProps {
    var component: String
    var container: Boolean
    var item: Boolean
    var zeroMinWidth: Boolean
}

var UiGridProps.alignContent by EnumPropToString(UiGridAlignContent.values())
var UiGridProps.alignItems by EnumPropToString(UiGridAlignItems.values())
var UiGridProps.direction by EnumPropToString(UiGridDirection.values())
var UiGridProps.justify by EnumPropToString(MGridJustify.values())
var UiGridProps.lg by UiGridSizeDelegate()
var UiGridProps.md by UiGridSizeDelegate()
var UiGridProps.sm by UiGridSizeDelegate()
var UiGridProps.spacing by UiGridSpacingDelegate()
var UiGridProps.wrap by EnumPropToString(UiGridWrap.values())
var UiGridProps.xl by UiGridSizeDelegate()
var UiGridProps.xs by UiGridSizeDelegate()

class UiGridSizeDelegate : ReadWriteProperty<RProps, UiGridSize?> {
    override fun getValue(thisRef: RProps, property: KProperty<*>): UiGridSize? {
        return when (thisRef.asDynamic()[property.name]) {
            null -> null
            undefined -> null
            true -> UiGridSize.cellsTrue
            false -> UiGridSize.cellsFalse
            1 -> UiGridSize.cells1
            2 -> UiGridSize.cells2
            3 -> UiGridSize.cells3
            4 -> UiGridSize.cells4
            5 -> UiGridSize.cells5
            6 -> UiGridSize.cells6
            7 -> UiGridSize.cells7
            8 -> UiGridSize.cells8
            9 -> UiGridSize.cells9
            10 -> UiGridSize.cells10
            11 -> UiGridSize.cells11
            12 -> UiGridSize.cells12
            else -> UiGridSize.cellsAuto
        }
    }

    override fun setValue(thisRef: RProps, property: KProperty<*>, value: UiGridSize?) {
        thisRef.asDynamic()[property.name] = value?.sizeVal
    }
}

class UiGridSpacingDelegate : ReadWriteProperty<RProps, UiGridSpacing?> {
    override fun getValue(thisRef: RProps, property: KProperty<*>): UiGridSpacing? {
        return when (thisRef.asDynamic()[property.name]) {
            null -> null
            undefined -> null
            1 -> UiGridSpacing.spacing1
            2 -> UiGridSpacing.spacing2
            3 -> UiGridSpacing.spacing3
            4 -> UiGridSpacing.spacing4
            5 -> UiGridSpacing.spacing5
            6 -> UiGridSpacing.spacing6
            7 -> UiGridSpacing.spacing7
            8 -> UiGridSpacing.spacing8
            9 -> UiGridSpacing.spacing9
            10 -> UiGridSpacing.spacing10
            else -> UiGridSpacing.spacing0
        }
    }

    override fun setValue(thisRef: RProps, property: KProperty<*>, value: UiGridSpacing?) {
        thisRef.asDynamic()[property.name] = value?.size
    }
}

/**
 * The material design components allows a grid item to be a container and an item. We have simplified things here
 * since different properties apply depending on if it is a container or an item. So, if you want both, you will have
 * to add an extra child item.
 */
fun RBuilder.uiGridContainer(
    spacing: UiGridSpacing = UiGridSpacing.spacing0,
    alignContent: UiGridAlignContent = UiGridAlignContent.stretch,
    alignItems: UiGridAlignItems = UiGridAlignItems.stretch,
    justify: MGridJustify = MGridJustify.flexStart,
    wrap: UiGridWrap = UiGridWrap.wrap,

    className: String? = null,
    handler: StyledHandler<UiGridProps>? = null
) = createStyled(uiGridComponent) {
    attrs.alignContent = alignContent
    attrs.alignItems = alignItems
    attrs.container = true
    attrs.justify = justify
    attrs.spacing = spacing
    attrs.wrap = wrap

    setStyledPropsAndRunHandler(className, handler)
}

fun RBuilder.uiGridItem(
    xs: UiGridSize = UiGridSize.cellsFalse,
    sm: UiGridSize = UiGridSize.cellsFalse,
    md: UiGridSize = UiGridSize.cellsFalse,
    lg: UiGridSize = UiGridSize.cellsFalse,
    xl: UiGridSize = UiGridSize.cellsFalse,
    zeroMinWidth: Boolean? = null,

    className: String? = null,
    handler: StyledHandler<UiGridProps>? = null
) = createStyled(uiGridComponent) {
    attrs.item = true
    attrs.sm = sm
    attrs.md = md
    attrs.lg = lg
    attrs.xs = xs
    attrs.xl = xl
    zeroMinWidth?.let { attrs.zeroMinWidth = it }

    setStyledPropsAndRunHandler(className, handler)
}

fun RBuilder.uiGridItem(
    breakpoints: UiGridBreakpoints,
    className: String? = null,
    handler: StyledHandler<UiGridProps>? = null
) =
    uiGridItem(
        breakpoints.xs,
        breakpoints.sm,
        breakpoints.md,
        breakpoints.lg,
        breakpoints.xl,
        null,
        className,
        handler
    )
