public class ExpSize extends Exp{

    Exp vec;
    public ExpSize(Exp vecPass)
    {
        super("size", vecPass);
        vec = vecPass;
    }
    
    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpSize(this, arg);
    }

    @Override
    public String toString() {
        return "size(" + vec + ")";
    }
}
