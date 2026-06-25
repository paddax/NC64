package com.github.paddax.nc64.highlighting

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import com.github.paddax.nc64.NC64Icons
import javax.swing.Icon

class NC64ColorSettingsPage : ColorSettingsPage {
    override fun getIcon(): Icon = NC64Icons.FILE

    override fun getHighlighter(): SyntaxHighlighter = NC64SyntaxHighlighter()

    override fun getDemoText(): String = """
        ; Example NC64 script
        %moveNomOff(NomIndex: Integer, Standoff: Real = 0, Offset: Vector)
        var VC: Vector
        KMode(1)
        _X = Nominal['X', NomIndex]
        _Y = Nominal['Y', NomIndex]
        _Z = Nominal['Z', NomIndex]
        VC = Vec(_I, _J, _K)
        VC = VC.Scale(Standoff)
        
        SetMonitorPoint(0, Vec(_X, _Y, _Z))
        _S = Nominal['S', NomIndex]
        G06 X(_X + VC.X()) Y(_Y + VC.Y()) Z(_Z + VC.Z()) ~
            I(_I) J(_J) K(_K) S(_S) F15000 
        
        ; Move to machine space offset if programmed
        if(Offset.Length() > 0.001) 
            KMode(0)
            G91 X(Offset.X()) Y(Offset.Y()) Z(Offset.Z()) 
            G90
            KMode(1)
        end
        return
        
        %station()
        callsub 'pos:Station'()
        return
    """.trimIndent()

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey>? = null

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> = DESCRIPTORS

    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY

    override fun getDisplayName(): String = "NC64"

    companion object {
        private val DESCRIPTORS = arrayOf(
            AttributesDescriptor("Keyword", NC64SyntaxHighlighter.KEYWORD),
            AttributesDescriptor("Number", NC64SyntaxHighlighter.NUMBER),
            AttributesDescriptor("String", NC64SyntaxHighlighter.STRING),
            AttributesDescriptor("Comment", NC64SyntaxHighlighter.COMMENT),
            AttributesDescriptor("Identifier", NC64SyntaxHighlighter.IDENTIFIER),
            AttributesDescriptor("Operator", NC64SyntaxHighlighter.OPERATOR),
            AttributesDescriptor("G-Code Command", NC64SyntaxHighlighter.G_CODE),
            AttributesDescriptor("Axis/Parameter", NC64SyntaxHighlighter.AXIS),
            AttributesDescriptor("Local Variable", NC64SyntaxHighlighter.LOCAL_VAR),
            AttributesDescriptor("Function Call", NC64SyntaxHighlighter.FUNCTION_CALL),
            AttributesDescriptor("Function Definition", NC64SyntaxHighlighter.FUNCTION_DEF),
            AttributesDescriptor("Line Continuation", NC64SyntaxHighlighter.LINE_CONTINUATION)
        )
    }
}
