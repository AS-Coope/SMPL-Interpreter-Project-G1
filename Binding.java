public class Binding extends Exp{
    private String id;
    private Exp value;

    public Binding(String id, Exp value) {
        super(id, value);
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpBind(this, arg);
    }

    public Exp getValueExp() {
        return value;
    }

    @Override
    public String toString(){
        return "";
    }
}
