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
    public long getChar() {
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

//endOfLine = nl|\n|\r

cc = ([\b\f]|{nl})

ws = {cc}|[\t ]

alpha = [a-zA-Z_]

alphanum = {alpha}|[0-9]

signedint = [+|-][0-9]+ 
hexint = #x([0-9a-fA-Z]+) 
binint = #b([0|1]+)

// generates signed integers
// first regex only deals with numbers and signs
// second regex deals with hexadecimal
// third regex deals with binary

signedDouble = ([+|-][0-9]+[.][0-9]*) | ([+|-][0-9]*[.]?[0-9]+) 

// might need to have {n,m} syntax given 32 ends at some point
// the first regex allows at least 1 digit before the decimal while none or many after the decimal
// the second regex allows none or many digits before the decimal while one or more after the decimal

//string = "({alpha}|[^cc]+|(\\n|\\t|\\b|\\f)+)"
string = \".*\"
//character = "#c({alpha}|[^cc]|(\\n|\\t|\\b|\\f)+)" | "[#u][0-9a-fA-F]{4}" // second part is the hexadecimal and only 4 digits allowed

inlineComment = "//" {nl}
multilineComment = "/*" [^*] ~"*/" | "/*" "*"+ "/"
Comment = {multilineComment}

%state YYCOMMENT

%%

<YYINITIAL>	{nl}	{//skip newline, but reset char counter
			 yychar = 0;
			}
<YYINITIAL>	{ws}	{
			 // skip whitespace
			}
//<YYINITIAL> {inlineComment} { }
<YYINITIAL> "//".* {}
// keywords
<YYINITIAL> "proc" {return new Symbol(sym.PROC);}
<YYINITIAL> "def" {return new Symbol(sym.DEF);}
<YYINITIAL> "call" {return new Symbol(sym.CALL);}
<YYINITIAL> "let" {return new Symbol(sym.LET);}
<YYINITIAL> "case" {return new Symbol(sym.CASE);}

<YYINITIAL> "if" {return new Symbol(sym.IF);}
<YYINITIAL> "else" {return new Symbol(sym.ELSE);}
<YYINITIAL> "then" {return new Symbol(sym.THEN);}
<YYINITIAL> "end" {return new Symbol(sym.END);} // needs to be removed (both here and parser) for final

<YYINITIAL> "pair" {return new Symbol(sym.PAIR);}
<YYINITIAL> "car" {return new Symbol(sym.CAR);}
<YYINITIAL> "cdr" {return new Symbol(sym.CDR);}
<YYINITIAL> "pair?" {return new Symbol(sym.ISPAIR);}
<YYINITIAL> "list" {return new Symbol(sym.LIST);}
<YYINITIAL> "eqv?" {return new Symbol(sym.ISEQV);}
<YYINITIAL> "equal?" {return new Symbol(sym.ISEQUAL);}
<YYINITIAL> "substr" {return new Symbol(sym.SUBSTR);}

<YYINITIAL> "print" {return new Symbol(sym.PRINT);}
<YYINITIAL> "println" {return new Symbol(sym.PRINTLN);}
<YYINITIAL> "read" {return new Symbol(sym.READ);}
<YYINITIAL> "readint" {return new Symbol(sym.READINT);}

// ARITHMETIC OPERATORS
<YYINITIAL>	"+"	{return new Symbol(sym.PLUS);}
<YYINITIAL>	"-"	{return new Symbol(sym.MINUS);}
<YYINITIAL>	"*"	{return new Symbol(sym.MUL);}
<YYINITIAL>	"/"	{return new Symbol(sym.DIV);}
<YYINITIAL>	"%"	{return new Symbol(sym.MOD);}
<YYINITIAL> "^" {return new Symbol(sym.POW);}

// IMPORTANT SYMBOLS/CHARACTERS
<YYINITIAL>	":="	{return new Symbol(sym.ASSIGN);}
<YYINITIAL>	"("	{return new Symbol(sym.LPAREN);}
<YYINITIAL>	")"	{return new Symbol(sym.RPAREN);}
<YYINITIAL>	";"	{return new Symbol(sym.SEMI);}
<YYINITIAL>	","	{return new Symbol(sym.COMMA);}
<YYINITIAL> "fun" {return new Symbol(sym.FUN);} // remove in parser(proc now defines functions)
<YYINITIAL>	"="	{return new Symbol(sym.EQU);}
<YYINITIAL>	"{"	{return new Symbol(sym.LBRACE);} 
<YYINITIAL>	"}"	{return new Symbol(sym.RBRACE);}
<YYINITIAL> ":" {return new Symbol(sym.COLON);}
<YYINITIAL> "[" {return new Symbol(sym.LSQBRAC);}
<YYINITIAL> "]" {return new Symbol(sym.RSQBRAC);}

// COMPARATORS
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
<YYINITIAL> "#f" {return new Symbol(sym.FALSE);}
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

<YYINITIAL>    {alpha}{alphanum}* {
	       // VAR
	       return new Symbol(sym.VAR, yytext());
		}

// covers the three representations of signed integers
<YYINITIAL> {signedint} {return new Symbol(sym.INT, Integer.valueOf(yytext().substring(1)));}
<YYINITIAL> {hexint} {return new Symbol(sym.INT, Integer.valueOf(yytext().substring(2),16));}
<YYINITIAL> {binint} {return new Symbol(sym.INT, Integer.valueOf(yytext().substring(2),2));}
//<YYINITIAL> {signedDouble} {sym.DOUBLE, Double.yytext();}
<YYINITIAL>  {signedDouble} {
			return new Symbol(sym.DOUBLE, Double.valueOf(yytext()));
			}
<YYINITIAL>  {string} {
			return new Symbol(sym.STRING, yytext());
			}

<YYINITIAL>    \S		{ // error situation
	       String msg = String.format("Unrecognised Token: %s", yytext());
	       throw new TokenException(msg);
	       }

// the lexical state definition for comments with the lexical rules
<YYCOMMENT> {Comment} {/* overlook whatever exists here*/ 
								yybegin(YYINITIAL);}