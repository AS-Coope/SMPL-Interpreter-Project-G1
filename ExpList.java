public class ExpList extends Exp {

    Exp[] elements;

    public ExpList(Exp... elements) {
        super("list", elements);
        this.elements = elements;
    }

    public Exp[] getElements() {
        return elements;
    }

    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpList(this, arg);
    }

    @Override
    public String toString() {
        String result = "list(";
        for (int i = 0; i < elements.length; i++) {
            result += elements[i];
            if (i < elements.length - 1) {
                result += ", ";
            }
        }
        result += ")";
        return result;
    }
}