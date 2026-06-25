package com.github.paddax.nc64.highlighting

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import com.github.paddax.nc64.lexer.NC64LexerAdapter
import com.github.paddax.nc64.psi.NC64Types

class NC64SyntaxHighlighter : SyntaxHighlighterBase() {

    override fun getHighlightingLexer(): Lexer = NC64LexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return when (tokenType) {
            NC64Types.KEYWORD -> KEYWORD_KEYS
            NC64Types.NUMBER -> NUMBER_KEYS
            NC64Types.STRING -> STRING_KEYS
            NC64Types.COMMENT -> COMMENT_KEYS
            NC64Types.IDENTIFIER -> IDENTIFIER_KEYS
            NC64Types.OPERATOR -> OPERATOR_KEYS
            NC64Types.G_CODE -> G_CODE_KEYS
            NC64Types.AXIS -> AXIS_KEYS
            NC64Types.LOCAL_VAR -> LOCAL_VAR_KEYS
            NC64Types.FUNCTION_CALL -> FUNCTION_CALL_KEYS
            NC64Types.FUNCTION_DEF -> FUNCTION_DEF_KEYS
            NC64Types.LINE_CONTINUATION -> LINE_CONTINUATION_KEYS
            TokenType.BAD_CHARACTER -> BAD_CHAR_KEYS
            else -> EMPTY_KEYS
        }
    }

    companion object {
        val KEYWORD = TextAttributesKey.createTextAttributesKey("NC64_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
        val NUMBER = TextAttributesKey.createTextAttributesKey("NC64_NUMBER", DefaultLanguageHighlighterColors.NUMBER)
        val STRING = TextAttributesKey.createTextAttributesKey("NC64_STRING", DefaultLanguageHighlighterColors.STRING)
        val COMMENT = TextAttributesKey.createTextAttributesKey("NC64_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        val IDENTIFIER = TextAttributesKey.createTextAttributesKey("NC64_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER)
        val OPERATOR = TextAttributesKey.createTextAttributesKey("NC64_OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN)
        
        val G_CODE = TextAttributesKey.createTextAttributesKey("NC64_G_CODE", DefaultLanguageHighlighterColors.METADATA)
        val AXIS = TextAttributesKey.createTextAttributesKey("NC64_AXIS", DefaultLanguageHighlighterColors.CONSTANT)
        val LOCAL_VAR = TextAttributesKey.createTextAttributesKey("NC64_LOCAL_VAR", DefaultLanguageHighlighterColors.LOCAL_VARIABLE)
        val FUNCTION_CALL = TextAttributesKey.createTextAttributesKey("NC64_FUNCTION_CALL", DefaultLanguageHighlighterColors.FUNCTION_CALL)
        val FUNCTION_DEF = TextAttributesKey.createTextAttributesKey("NC64_FUNCTION_DEF", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION)
        val LINE_CONTINUATION = TextAttributesKey.createTextAttributesKey("NC64_LINE_CONTINUATION", DefaultLanguageHighlighterColors.VALID_STRING_ESCAPE)
        
        val BAD_CHARACTER = TextAttributesKey.createTextAttributesKey("NC64_BAD_CHARACTER", DefaultLanguageHighlighterColors.INVALID_STRING_ESCAPE)

        private val KEYWORD_KEYS = arrayOf(KEYWORD)
        private val NUMBER_KEYS = arrayOf(NUMBER)
        private val STRING_KEYS = arrayOf(STRING)
        private val COMMENT_KEYS = arrayOf(COMMENT)
        private val IDENTIFIER_KEYS = arrayOf(IDENTIFIER)
        private val OPERATOR_KEYS = arrayOf(OPERATOR)
        private val G_CODE_KEYS = arrayOf(G_CODE)
        private val AXIS_KEYS = arrayOf(AXIS)
        private val LOCAL_VAR_KEYS = arrayOf(LOCAL_VAR)
        private val FUNCTION_CALL_KEYS = arrayOf(FUNCTION_CALL)
        private val FUNCTION_DEF_KEYS = arrayOf(FUNCTION_DEF)
        private val LINE_CONTINUATION_KEYS = arrayOf(LINE_CONTINUATION)
        private val BAD_CHAR_KEYS = arrayOf(BAD_CHARACTER)
        private val EMPTY_KEYS = emptyArray<TextAttributesKey>()
    }
}
