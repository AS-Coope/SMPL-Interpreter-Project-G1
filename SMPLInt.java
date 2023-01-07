public class SMPLInt extends SMPLObject {
    private int value;

    // empty constructor for default initialization
    public SMPLInt() {
        
    }

    public SMPLInt(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int val){
        this.value = val;
    }

    @Override
    public SMPLObject add(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLInt) {
            return new SMPLInt(value + ((SMPLInt) obj).getValue());
        } else if (obj instanceof SMPLDouble) {
            return new SMPLDouble(value + ((SMPLInt) obj).getValue());
        } else {
            throw new SMPLException("Cannot add non-integer values");
        }
    }

    @Override
    public SMPLObject sub(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLInt) {
            return new SMPLInt(value - ((SMPLInt) obj).getValue());
        } else if (obj instanceof SMPLDouble) {
            return new SMPLDouble(value + ((SMPLInt) obj).getValue());
        } else {
            throw new SMPLException("Cannot subtract non-integer values");
        }
    }

    @Override
    public SMPLObject mult(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLInt) {
            return new SMPLInt(value * ((SMPLInt) obj).getValue());
        } else if (obj instanceof SMPLDouble) {
            return new SMPLDouble(value + ((SMPLInt) obj).getValue());
        } else {
            throw new SMPLException("Cannot multiply non-integer values");
        }
    }

    @Override
    public SMPLObject div(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLInt) {
            return new SMPLInt(value / ((SMPLInt) obj).getValue());
        } else if (obj instanceof SMPLDouble) {
            return new SMPLDouble(value + ((SMPLInt) obj).getValue());
        } else {
            throw new SMPLException("Cannot divide non-integer values");
        }
    }

    @Override
    public SMPLObject mod(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLInt) {
            return new SMPLInt(value % ((SMPLInt) obj).getValue());
        } else if (obj instanceof SMPLDouble) {
            return new SMPLDouble(value + ((SMPLInt) obj).getValue());
        } else {
            throw new SMPLException("Cannot perform modulo operation on non-integer values");
        }
    }

    // relational operators

    @Override
    public SMPLObject lessthan(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLInt) {
            return new SMPLBoolean(value < ((SMPLInt) obj).getValue());
        } else if (obj instanceof SMPLDouble) {
            return new SMPLBoolean(value < ((SMPLInt) obj).getValue());
        } else {
            throw new SMPLException("Cannot perform less than operation on non-double values");
        }
    }

    @Override
    public SMPLObject greaterthan(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLInt) {
            return new SMPLBoolean(value > ((SMPLInt) obj).getValue());
        } else if (obj instanceof SMPLDouble) {
            return new SMPLBoolean(value > ((SMPLInt) obj).getValue());
        } else {
            throw new SMPLException("Cannot perform greater than operation on non-double values");
        }
    }

    @Override
    public SMPLObject greateqto(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLInt) {
            return new SMPLBoolean(value >= ((SMPLInt) obj).getValue());
        } else if (obj instanceof SMPLDouble) {
            return new SMPLBoolean(value >= ((SMPLInt) obj).getValue());
        } else {
            throw new SMPLException("Cannot perform greater than or equal to operation on non-double values");
        }
    }

    @Override
    public SMPLObject lesseqto(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLInt) {
            return new SMPLBoolean(value <= ((SMPLInt) obj).getValue());
        } else if (obj instanceof SMPLDouble) {
            return new SMPLBoolean(value <= ((SMPLInt) obj).getValue());
        } else {
            throw new SMPLException("Cannot perform less than or equal to operation on non-double values");
        }
    }

    @Override
    public SMPLObject equalto(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLInt) {
            return new SMPLBoolean(value == ((SMPLInt) obj).getValue());
        } else if (obj instanceof SMPLDouble) {
            return new SMPLBoolean(value == ((SMPLInt) obj).getValue());
        } else {
            throw new SMPLException("Cannot perform equal to operation on non-double values");
        }
    }

    @Override
    public SMPLObject notequal(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLInt) {
            return new SMPLBoolean(value != ((SMPLInt) obj).getValue());
        } else if (obj instanceof SMPLDouble) {
            return new SMPLBoolean(value != ((SMPLInt) obj).getValue());
        } else {
            throw new SMPLException("Cannot perform not equal to operation on non-double values");
        }
    }
}