public class SMPLBoolean extends SMPLObject {

    private boolean value;

    public SMPLBoolean(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
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
}