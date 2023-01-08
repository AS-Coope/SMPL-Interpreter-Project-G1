

public class ExpIf extends Exp {

    /* 
    ExpLogic predicate;
    Exp consequent;
    Exp alternative;
    public ExpIf(ExpLogic pred, Exp con) {
        super("IfStatement");
        predicate = pred;
        consequent = con;
    }

    public ExpIf(ExpLogic pred, Exp con, Exp alt) {
        super("IfElseStatement");
        predicate = pred;
        consequent = con;
        alternative = alt;
    }*/

    Exp predicate; //condition
    Exp consequent; //thenBranch
    Exp alternate; //elseBranch

    public ExpIf(Exp pred, Exp con, Exp alt) {
        super("IfElseStatement");
        predicate = pred;
        consequent = con;
        alternate = alt;
    }

    public ExpIf(Exp pred, Exp con) {
        this(pred, con, null);
    }

    public Exp getPredicate() {
        return predicate;
    }

    public Exp getConsequent() {
        return consequent;
    }

    public Exp getAlternate() {
        return alternate;
    }

    public boolean hasAlternate() {
        return alternate != null;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        
        return v.visitExpIf(this, arg);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("if ");
        sb.append(predicate.toString());
        sb.append(" then ");
        sb.append(consequent.toString());
        if (hasAlternate()) {
            sb.append(" else ");
            sb.append(alternate.toString());
        }
        return sb.toString();
    }
 
}
