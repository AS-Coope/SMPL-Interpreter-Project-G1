public class ExpIf extends Exp {
    private Exp condition;
    private Exp thenBranch;
    private Exp elseBranch;

    public ExpIf(Exp condition, Exp thenBranch, Exp elseBranch) {
        super("if");
        this.condition = condition;
        this.thenBranch = thenBranch;
        this.elseBranch = elseBranch;
    }

    public ExpIf(Exp condition, Exp thenBranch) {
        this(condition, thenBranch, null);
    }

    public Exp getCondition() {
        return condition;
    }

    public Exp getThenBranch() {
        return thenBranch;
    }

    public Exp getElseBranch() {
        return elseBranch;
    }

    public boolean hasElseBranch() {
        return elseBranch != null;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpIf(this, arg);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("if ");
        sb.append(condition.toString());
        sb.append(" then ");
        sb.append(thenBranch.toString());
        if (hasElseBranch()) {
            sb.append(" else ");
            sb.append(elseBranch.toString());
        }
        return sb.toString();
    }
}