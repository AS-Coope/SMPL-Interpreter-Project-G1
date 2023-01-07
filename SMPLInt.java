public class SMPLInt extends SMPLObject {
    private int value;

    public SMPLInt(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public SMPLObject add(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLInt) {
            return new SMPLInt(value + ((SMPLInt) obj).getValue());
        } else {
            throw new SMPLException("Cannot add non-integer values");
        }
    }

    @Override
    public SMPLObject sub(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLInt) {
            return new SMPLInt(value - ((SMPLInt) obj).getValue());
        } else {
            throw new SMPLException("Cannot subtract non-integer values");
        }
    }

    @Override
    public SMPLObject mult(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLInt) {
            return new SMPLInt(value * ((SMPLInt) obj).getValue());
        } else {
            throw new SMPLException("Cannot multiply non-integer values");
        }
    }

    @Override
    public SMPLObject div(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLInt) {
            return new SMPLInt(value / ((SMPLInt) obj).getValue());
        } else {
            throw new SMPLException("Cannot divide non-integer values");
        }
    }

    @Override
    public SMPLObject mod(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLInt) {
            return new SMPLInt(value % ((SMPLInt) obj).getValue());
        } else {
            throw new SMPLException("Cannot perform modulo operation on non-integer values");
        }
    }
}