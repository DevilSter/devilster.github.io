package components.layout

import bootstrapUi.*
import bootstrapUi.button.BsButtonSize
import bootstrapUi.button.BsButtonType
import bootstrapUi.button.bsButtonLink
import bootstrapUi.grid.BsCols
import bootstrapUi.grid.BsFlex
import bootstrapUi.grid.bsRColumn
import bootstrapUi.grid.bsRow
import bootstrapUi.svg.*
import react.*
import styled.StyledProps
import styled.css
import styled.styledHeader

external interface HeaderProps : StyledProps

private class Header : RComponent<HeaderProps, RState>() {

    override fun RBuilder.render() {
        styledHeader {
            css {
                +HeaderStyles.blogHeader
            }

            bsRow {
                attrs {
                    flex = BsFlex.NOWRAP
                    contentFormat = BsContentFormat.JUSTIFY_BETWEEN
                    itemsAlign = BsItemsAlign.CENTER
                }

                bsRColumn {
                    attrs {
                        cols = BsCols.COL4
                        spacing = "pt-1"
                    }

                    bsLink(href = "#") {
                        attrs {
                            textFormat = BsTextFormat.MUTED
                        }
                        +"Subscribe"
                    }
                }

                bsRColumn {
                    attrs {
                        cols = BsCols.COL4
                        textAlign = BsTextAlign.CENTER
                    }

                    bsLink(href = "#") {
                        attrs {
                            textFormat = BsTextFormat.DARK
                        }

                        css {
                            +HeaderStyles.blogHeaderLogo
                        }

                        +"Large"
                    }
                }

                bsRColumn {
                    attrs {
                        cols = BsCols.COL4
                        flex = BsFlex.D_FLEX
                        contentFormat = BsContentFormat.JUSTIFY_END
                        itemsAlign = BsItemsAlign.CENTER
                    }

                    bsLink(href = "#") {
                        attrs {
                            textFormat = BsTextFormat.MUTED
                            ariaLabel = "Search"
                        }

                        bsSVG(title = "Search", className = "mx-3") {
                            attrs {
                                xmlns = "http://www.w3.org/2000/svg"
                                width = "20"
                                height = "20"
                                fill = BsSVGColorOptions.NONE
                                stroke = BsSVGColorOptions.CURRENT_COLOR
                                strokeLinecap = BsSVGStrokeOptions.ROUND
                                strokeLinejoin = BsSVGStrokeOptions.ROUND
                                strokeWidth = 2
                                viewBox = "0 0 24 24"

                                role = "img"
                            }

                            bsSVGCircle(10.5, 10.5, 7.5)
                            bsSVGPath("M21 21l-5.2-5.2")
                        }
                    }

                    bsButtonLink(
                        href = "#",
                        type = BsButtonType.OUTLINE_SECONDARY,
                        size = BsButtonSize.SMALL
                    ) {
                        +"Sign Up"
                    }
                }
            }
        }
    }
}

fun RBuilder.header(handler: HeaderProps.() -> Unit): ReactElement {
    return child(Header::class) {
        attrs {
            handler()
        }
    }
}