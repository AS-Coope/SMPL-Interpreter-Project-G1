/* Specification for ArithExp tokens */

// user customisations
import java_cup.runtime.*;
import lib3652.util.TokenException;

// Jlex directives
    
%%

%cup
%public

%class Lexer

%type java_cup.runtime.Symbol

%throws TokenException

%eofval{
	return new Symbol(sym.EOF);
%eofval}

%eofclose false

%char
%column
%line

%{
    public int getChar() {
	return yychar + 1;
    }

    public int getColumn() {
    	return yycolumn + 1;
    }

    public int getLine() {
	return yyline + 1;
    }

    public String getText() {
	return yytext();
    }
%}

nl = [\n\r]

cc = ([\b\f]|{nl})

ws = {cc}|[\t ]

alpha = [a-zA-Z_]

alphanum = {alpha}|[0-9]

signedint = [+|-][0-9]+ // generates signed integers

string = "[^cc]"

%%

<YYINITIAL>	{nl}	{//skip newline, but reset char counter
			 yychar = 0;
			}
<YYINITIAL>	{ws}	{
			 // skip whitespace
			}
<YYINITIAL>	"+"	{return new Symbol(sym.PLUS);}
<YYINITIAL>	"-"	{return new Symbol(sym.MINUS);}
<YYINITIAL>	"*"	{return new Symbol(sym.MUL);}
<YYINITIAL>	"/"	{return new Symbol(sym.DIV);}
<YYINITIAL>	"%"	{return new Symbol(sym.MOD);}
<YYINITIAL> "^" {return new Symbol(sym.EXPO);}

<YYINITIAL>	":="	{return new Symbol(sym.ASSIGN);}
<YYINITIAL>	"("	{return new Symbol(sym.LPAREN);}
<YYINITIAL>	")"	{return new Symbol(sym.RPAREN);}
<YYINITIAL>	";"	{return new Symbol(sym.SEMI);}
<YYINITIAL>	","	{return new Symbol(sym.COMMA);}
<YYINITIAL> "fun" {return new Symbol(sym.FUN);}
<YYINITIAL>	"="	{return new Symbol(sym.EQU);}
<YYINITIAL>	"{"	{return new Symbol(sym.LBRACE);} 
<YYINITIAL>	"}"	{return new Symbol(sym.RBRACE);}
<YYINITIAL> "if" {return new Symbol(sym.IF);}
<YYINITIAL> ":" {return new Symbol(sym.COLON);}
<YYINITIAL> "else" {return new Symbol(sym.ELSE);}
<YYINITIAL> "end" {return new Symbol(sym.END);}
<YYINITIAL> "<" {return new Symbol(sym.CMP,Cmp.LT);}
<YYINITIAL> "<=" {return new Symbol(sym.CMP,Cmp.LE);}
// <YYINITIAL> "=" {return new Symbol(sym.CMP,CMP.EQ);} 
<YYINITIAL> "!=" {return new Symbol(sym.CMP,Cmp.NE);}
<YYINITIAL> ">" {return new Symbol(sym.CMP,Cmp.GT);}
<YYINITIAL> ">=" {return new Symbol(sym.CMP,Cmp.GE);}
<YYINITIAL>    [0-9]+ {
	       // INTEGER
	       return new Symbol(sym.INT, 
				 Integer.valueOf(yytext()));
		}

<YYINITIAL> "#t" {return new Symbol(sym.TRUE);}
<YYINITIAL> "#f" {return new Symbol(sym.FALSE;)}
<YYINITIAL> "#e" {return new Symbol(sym.EMPLS);} // empty list (nil)

// LOGICAL OPERATORS
<YYINITIAL> "and" {return new Symbol(sym.AND);}
<YYINITIAL> "or" {return new Symbol(sym.OR);}
<YYINITIAL> "not" {return new Symbol(sym.NOT);}

// LIST CONCATENATION
<YYINITIAL> "@" {return new Symbol(sym.LSCONCAT);}

// BITWISE OPERATORS
<YYINITIAL> "&" {return new Symbol(sym.BWAND);}
<YYINITIAL> "|" {return new Symbol(sym.BWOR);}
<YYINITIAL> "~" {return new Symbol(sym.BWNOT);}

<YYINITIAL> "pair" {return new Symbol(sym.PAIR);}
<YYINITIAL> "car" {return new Symbol(sym.CAR);}
<YYINITIAL> "cdr" {return new Symbol(sym.CDR);}
<YYINITIAL> "pair?" {return new Symbol(sym.ISPAIR);}
<YYINITIAL> "list" {return new Symbol(sym.LIST);}

<YYINITIAL>    {alpha}{alphanum}* {
	       // VAR
	       return new Symbol(sym.VAR, yytext());
		}

<YYINITIAL>    \S		{ // error situation
	       String msg = String.format("Unrecognised Token: %s", yytext());
	       throw new TokenException(msg);
	       }