public class ExpPrint extends Exp {
    
    // can print an expression (or variable) or an SMPLString
    Exp expression;
    String printString;
    public ExpPrint(Exp exp, String pString){
        super("print");
        exp = expression;
        pString = printString;
    }

    public Exp getExp(){
        return expression;
    }

    public String getString(){
        return printString;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpPrint(this, arg);
    }

    @Override
    public String toString() {
        return "";
    }
}
