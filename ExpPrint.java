public class ExpPrint extends Exp {
    private Exp exp;

    public ExpPrint(Exp exp) {
        super("print");
        this.exp = exp;
    }

    public Exp getExp() {
        return exp;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpPrint(this, arg);
    }

    @Override
    public String toString() {
        return "print(" + exp + ")";
    }
}