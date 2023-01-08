public class ExpSubstr extends Exp {
    Exp stringExpr;
    Exp startIndexExpr;
    Exp endIndexExpr;

    public ExpSubstr(Exp stringExpr, Exp startIndexExpr, Exp endIndexExpr) {
        super("substr", stringExpr, startIndexExpr, endIndexExpr);
        this.stringExpr = stringExpr;
        this.startIndexExpr = startIndexExpr;
        this.endIndexExpr = endIndexExpr;
    }

    public Exp getStringExpr() {
        return stringExpr;
    }

    public Exp getStartIndexExpr() {
        return startIndexExpr;
    }

    public Exp getEndIndexExpr() {
        return endIndexExpr;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpSubstr(this, arg);
    }

    @Override
    public String toString() {
        return "substr(" + stringExpr + ", " + startIndexExpr + ", " + endIndexExpr + ")";
    }
}