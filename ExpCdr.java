public class ExpCdr extends Exp {
    Exp pair;

    public ExpCdr(Exp p) {
        super("cdr", p);
        pair = p;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpCdr(this, arg);
    }

    public Exp getPair() {
        return pair;
    }

    @Override
    public String toString() {
        return "cdr(" + pair + ")";
    }
}
