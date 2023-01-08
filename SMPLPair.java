public class SMPLPair extends SMPLObject {

    private SMPLObject first;
    private SMPLObject second;

    // empty constructor for default initialization
    public SMPLPair() {
    }

    public SMPLPair(SMPLObject first, SMPLObject second) {
        this.first = first;
        this.second = second;
    }

    public SMPLObject getFirst() {
        return first;
    }

    public SMPLObject getSecond() {
        return second;
    }

    @Override
    public SMPLObject iseqv(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLPair) {
            SMPLPair other = (SMPLPair) obj;

            return new SMPLBoolean(this.equals(other));
            /* 
            SMPLBoolean firstEqual = (SMPLBoolean) this.first.iseqv(other.getFirst());
            SMPLBoolean secondEqual = (SMPLBoolean) this.second.iseqv(other.getSecond());
            return new SMPLBoolean(firstEqual.getValue() && secondEqual.getValue());*/
        } else {
            return new SMPLBoolean(false);
        }
    }

    @Override
    public SMPLObject isequal(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLPair) {
            SMPLPair other = (SMPLPair) obj;
            SMPLBoolean firstEqual = (SMPLBoolean) this.first.isequal(other.getFirst());
            SMPLBoolean secondEqual = (SMPLBoolean) this.second.isequal(other.getSecond());
            return new SMPLBoolean(firstEqual.getValue() && secondEqual.getValue());
        } else {
            return new SMPLBoolean(false);
        }
    }

    @Override
    public SMPLObject isPair() throws SMPLException {
        return new SMPLBoolean(true);
    }

    @Override
    public SMPLObject car() throws SMPLException {
        return this.first;
    }

    @Override
    public SMPLObject cdr() throws SMPLException {
        return this.second;
    }

    @Override
    public String toString(){
        return "pair(" + first + ", " + second + ")";
    }

}