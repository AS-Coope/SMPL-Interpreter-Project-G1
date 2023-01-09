public class ExpPrintLn extends Exp {
    Exp exp;

    public ExpPrintLn(Exp exp) {
        super("println");
        this.exp = exp;
    }

    public Exp getExp() {
        return exp;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpPrintLn(this, arg);
    }

    @Override
    public String toString() {
        return "println(" + exp + ")";
    }
}