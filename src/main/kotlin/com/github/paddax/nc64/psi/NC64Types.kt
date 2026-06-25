package com.github.paddax.nc64.psi

import com.intellij.psi.tree.IElementType

object NC64Types {
    @JvmField val KEYWORD: IElementType = NC64TokenType("KEYWORD")
    @JvmField val NUMBER: IElementType = NC64TokenType("NUMBER")
    @JvmField val STRING: IElementType = NC64TokenType("STRING")
    @JvmField val COMMENT: IElementType = NC64TokenType("COMMENT")
    @JvmField val IDENTIFIER: IElementType = NC64TokenType("IDENTIFIER")
    @JvmField val OPERATOR: IElementType = NC64TokenType("OPERATOR")
    
    // New specific tokens
    @JvmField val G_CODE: IElementType = NC64TokenType("G_CODE")
    @JvmField val AXIS: IElementType = NC64TokenType("AXIS")
    @JvmField val LOCAL_VAR: IElementType = NC64TokenType("LOCAL_VAR")
    @JvmField val FUNCTION_CALL: IElementType = NC64TokenType("FUNCTION_CALL")
    @JvmField val FUNCTION_DEF: IElementType = NC64TokenType("FUNCTION_DEF")
    @JvmField val LINE_CONTINUATION: IElementType = NC64TokenType("LINE_CONTINUATION")

    @JvmField val BAD_CHARACTER: IElementType = NC64TokenType("BAD_CHARACTER")
}
