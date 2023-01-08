public class ExpPrintln extends Exp{
    // can either print a var (or expression) or a string
    Exp expression;
    String printString;
    
    public ExpPrintln(Exp ex, String inputString){
        super("println");
        printString = inputString;
        expression = ex;
    }

    public Exp getExp(){
        return expression;
    }

    public String getString(){
        return printString;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpPrintln(this, arg);
    }

    @Override
    public String toString() {
        
        return "";
    }
}
