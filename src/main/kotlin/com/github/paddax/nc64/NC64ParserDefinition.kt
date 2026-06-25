package com.github.paddax.nc64

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.tree.IElementType
import com.github.paddax.nc64.lexer.NC64LexerAdapter
import com.github.paddax.nc64.psi.NC64Types

val FILE = IFileElementType(NC64Language)

class NC64File(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, NC64Language) {
    override fun getFileType(): FileType = NC64FileType
    override fun toString(): String = "NC64 File"
}

class NC64Parser : PsiParser {
    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode {
        val mark = builder.mark()
        while (!builder.eof()) {
            builder.advanceLexer()
        }
        mark.done(root)
        return builder.treeBuilt
    }
}

class NC64ParserDefinition : ParserDefinition {
    override fun createLexer(project: Project?): Lexer = NC64LexerAdapter()
    
    override fun getWhitespaceTokens(): TokenSet = TokenSet.create(com.intellij.psi.TokenType.WHITE_SPACE)
    
    override fun getCommentTokens(): TokenSet = TokenSet.create(NC64Types.COMMENT)
    
    override fun getStringLiteralElements(): TokenSet = TokenSet.create(NC64Types.STRING)
    
    override fun createParser(project: Project?): PsiParser = NC64Parser()
    
    override fun getFileNodeType(): IFileElementType = FILE
    
    override fun createFile(viewProvider: FileViewProvider): PsiFile = NC64File(viewProvider)
    
    override fun spaceExistenceTypeBetweenTokens(left: ASTNode?, right: ASTNode?): ParserDefinition.SpaceRequirements = 
        ParserDefinition.SpaceRequirements.MAY
        
    override fun createElement(node: ASTNode?): PsiElement = ASTWrapperPsiElement(node!!)
}
