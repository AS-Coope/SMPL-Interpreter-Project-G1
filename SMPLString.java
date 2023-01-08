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

    @Override
    public SMPLObject iseqv(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLString) {
            SMPLString other = (SMPLString) obj;

            //return new SMPLBoolean(this.equals(other));
            return new SMPLBoolean(this.value == other.getValue());
            /* 
            SMPLBoolean firstEqual = (SMPLBoolean) this.first.iseqv(other.getFirst());
            SMPLBoolean secondEqual = (SMPLBoolean) this.second.iseqv(other.getSecond());
            return new SMPLBoolean(firstEqual.getValue() && secondEqual.getValue());*/
        } else {
            return new SMPLBoolean(false);
        }
    }

    @Override
    public String toString(){
        return value;
    }
}
