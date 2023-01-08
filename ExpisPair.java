public class ExpisPair extends Exp {
    Exp exp;

    public ExpisPair(Exp exp) {
        super("pair?", exp);
        this.exp = exp;
    }

    public Exp getExp() {
        return exp;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpisPair(this, arg);
    }

    @Override
    public String toString() {
        return "pair?(" + exp + ")";
    }
}
