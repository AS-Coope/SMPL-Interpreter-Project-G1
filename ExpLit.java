public class ExpLit extends Exp {

    SMPLObject val;

    public ExpLit(Integer v) {
	super(v.toString());
	val = new SMPLInt(v);
    }

    public ExpLit(Double v){
        super(v.toString());
	    val = new SMPLDouble(v);
    }

    public ExpLit(String v){
        super(v);
        val = new SMPLString(v);
    }

    public ExpLit(Boolean v){
        super(v.toString());
        val = new SMPLBoolean(v);
    }

    public SMPLObject getVal() {
	    return val;
    }

    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
	return v.visitExpLit(this, arg);
    }

    public String toString() {
	return val.toString();
    }
}

