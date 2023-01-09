import java.util.ArrayList;

public class ExpLet extends Exp {
    private ArrayList<Binding> bindings;
    private Exp body; //make body a stmtSequence

    public ExpLet(ArrayList<Binding> bindings, Exp body) {
        super("let");
        this.bindings = bindings;
        this.body = body;
    }

    public ArrayList<Binding> getBindings() {
        return bindings;
    }

    public Exp getBodyExp() {
        return body;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpLet(this, arg);
    }

    @Override
    public String toString() {
        String result = "let ";
        for (Binding b : bindings) {
            result += b.toString() + " ";
        }
        result += "in " + body.toString() + " end";
        return result;
    }
}
