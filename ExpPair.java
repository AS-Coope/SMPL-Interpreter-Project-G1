public class ExpPair extends Exp {

    Exp first;
    Exp second;

    public ExpPair(Exp first, Exp second) {
        super("pair", first, second);
        this.first = first;
        this.second = second;
    }

    public Exp getFirst() {
        return first;
    }

    public Exp getSecond() {
        return second;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpPair(this, arg);
    }

    @Override
    public String toString() {
        return "pair(" + first + ", " + second + ")";
    }
}