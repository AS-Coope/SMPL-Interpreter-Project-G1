public class Binding {
    private String id;
    private Exp value;

    public Binding(String id, Exp value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public Exp getValueExp() {
        return value;
    }
}
