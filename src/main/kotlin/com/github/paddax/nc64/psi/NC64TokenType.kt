package com.github.paddax.nc64.psi

import com.intellij.psi.tree.IElementType
import com.github.paddax.nc64.NC64Language

class NC64TokenType(debugName: String) : IElementType(debugName, NC64Language) {
    override fun toString(): String = "NC64TokenType." + super.toString()
}
