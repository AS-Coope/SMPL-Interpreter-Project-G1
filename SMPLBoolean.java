public class SMPLBoolean extends SMPLObject {

    private boolean value;

    // empty constructor for default initialization
    public SMPLBoolean() {
    }

    public SMPLBoolean(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean val){
        this.value = val;
    }

    @Override
    public SMPLObject iseqv(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLBoolean) {
            SMPLBoolean other = (SMPLBoolean) obj;
            return new SMPLBoolean(this.value == other.getValue());
        } else {
            return new SMPLBoolean(false);
        }
    }

    @Override
    public SMPLObject isequal(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLBoolean) {
            SMPLBoolean other = (SMPLBoolean) obj;
            return new SMPLBoolean(this.value == other.getValue());
        } else {
            return new SMPLBoolean(false);
        }
    }

    @Override
    public String toString(){
        if (value == true){
            return "#t";
        }
        return "#f";
    }
}