public class SMPLString extends SMPLObject {
    private String value;

    // empty constructor for default initialization
    public SMPLString() {
    }

    public SMPLString(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String val){
        this.value = val;
    }

    @Override
    public SMPLObject add(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLString) {
            return new SMPLString(value + ((SMPLString) obj).getValue());
        } else {
            throw new SMPLException("Cannot concatenate non-string values");
        }
    }

    @Override
    public SMPLObject substr(SMPLObject startIndex, SMPLObject endIndex) throws SMPLException {
        if (startIndex instanceof SMPLInt && endIndex instanceof SMPLInt) {
            int start = ((SMPLInt) startIndex).getValue();
            int end = ((SMPLInt) endIndex).getValue();
            return new SMPLString(value.substring(start, end));
        } else {
            throw new SMPLException("Start and end indexes must be integers");
        }
    }
}
