package com.github.paddax.nc64.lexer

import com.intellij.lexer.FlexAdapter
import com.github.paddax.nc64.lexer.gen._NC64Lexer
import java.io.Reader

class NC64LexerAdapter : FlexAdapter(_NC64Lexer(null as Reader?))
