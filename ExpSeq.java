import java.util.ArrayList;

public class ExpSeq extends Exp {
    private ArrayList<Exp> expressions;

    public ExpSeq(ArrayList<Exp> expressions) {
        super("seq");
        this.expressions = expressions;
    }

    public ArrayList<Exp> getExpressions() {
        return expressions;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpSeq(this, arg);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("seq(");
        for (Exp e : expressions) {
            sb.append(e.toString());
            sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }
}
