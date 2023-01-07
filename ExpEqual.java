public class ExpEqual extends Exp {
    private Exp exp1;
    private Exp exp2;

    public ExpEqual(Exp exp1, Exp exp2) {
        super("equal?");
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    public Exp getExp1() {
        return exp1;
    }

    public Exp getExp2() {
        return exp2;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpEqual(this, arg);
    }

    @Override
    public String toString() {
        return "equal?(" + exp1 + ", " + exp2 + ")";
    }
}