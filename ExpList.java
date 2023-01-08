import java.util.ArrayList;

public class ExpList extends Exp {

    ArrayList<Exp> elements;

    public ExpList(ArrayList<Exp> elements) {
        super("list", elements);
        this.elements = elements;
    }

    public ArrayList<Exp> getElements() {
        return elements;
    }

    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpList(this, arg);
    }

    @Override
    public String toString() {
        // String result = "list(";
        // for (int i = 0; i < elements.length; i++) {
        // result += elements[i];
        // if (i < elements.length - 1) {
        // result += ", ";
        // }
        // }
        // result += ")";
        return "result";
    }
}