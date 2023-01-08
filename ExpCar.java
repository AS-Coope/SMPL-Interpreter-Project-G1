public class ExpCar extends Exp {
    Exp pair;

    public ExpCar(Exp p) {
        super("car", p);
        pair = p;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpCar(this, arg);
    }

    public Exp getPair() {
        return pair;
    }

    @Override
    public String toString() {
        return "car(" + pair + ")";
    }

}