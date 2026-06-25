package com.github.paddax.nc64.lexer.gen;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.github.paddax.nc64.psi.NC64Types;
import com.intellij.psi.TokenType;

%%

%class _NC64Lexer
%public
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

WHITE_SPACE=[\ \n\t\f\r]
COMMENT=;.*
NUMBER=[0-9]+(\.[0-9]+)?
STRING='[^']*'

G_CODE=[GMgm][0-9][0-9]?
AXIS=[XYZIJKABCUVWxyzijkabcuvw]
LOCAL_VAR=_[a-zA-Z0-9_]+
FUNCTION_DEF=%[a-zA-Z0-9_]+
IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*
OPERATOR=[+\-*/=<>!]
LINE_CONTINUATION="~"

%%
<YYINITIAL> {
  {WHITE_SPACE} { return TokenType.WHITE_SPACE; }
  {COMMENT}     { return NC64Types.COMMENT; }
  {NUMBER}      { return NC64Types.NUMBER; }
  {STRING}      { return NC64Types.STRING; }
  
  "var"         { return NC64Types.KEYWORD; }
  "if"          { return NC64Types.KEYWORD; }
  "else"        { return NC64Types.KEYWORD; }
  "end"         { return NC64Types.KEYWORD; }
  "for"         { return NC64Types.KEYWORD; }
  "to"          { return NC64Types.KEYWORD; }
  "case"        { return NC64Types.KEYWORD; }
  "return"      { return NC64Types.KEYWORD; }
  "push"        { return NC64Types.KEYWORD; }
  "pop"         { return NC64Types.KEYWORD; }

  {G_CODE}      { return NC64Types.G_CODE; }
  {AXIS} / "("  { return NC64Types.AXIS; }
  {FUNCTION_DEF} { return NC64Types.FUNCTION_DEF; }
  
  {IDENTIFIER} / "(" { return NC64Types.FUNCTION_CALL; }

  {LOCAL_VAR}   { return NC64Types.LOCAL_VAR; }
  {IDENTIFIER}  { return NC64Types.IDENTIFIER; }
  
  {LINE_CONTINUATION} { return NC64Types.LINE_CONTINUATION; }
  {OPERATOR}    { return NC64Types.OPERATOR; }

  [^] { return NC64Types.BAD_CHARACTER; }
}
