public class SMPLDouble extends SMPLObject {
    private double value;

    public SMPLDouble(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public SMPLObject add(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLDouble) {
            return new SMPLDouble(value + ((SMPLDouble) obj).getValue());
        } else {
            throw new SMPLException("Cannot add non-double values");
        }
    }

    @Override
    public SMPLObject sub(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLDouble) {
            return new SMPLDouble(value - ((SMPLDouble) obj).getValue());
        } else {
            throw new SMPLException("Cannot subtract non-double values");
        }
    }

    @Override
    public SMPLObject mult(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLDouble) {
            return new SMPLDouble(value * ((SMPLDouble) obj).getValue());
        } else {
            throw new SMPLException("Cannot multiply non-double values");
        }
    }

    @Override
    public SMPLObject div(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLDouble) {
            return new SMPLDouble(value / ((SMPLDouble) obj).getValue());
        } else {
            throw new SMPLException("Cannot divide non-double values");
        }
    }

    @Override
    public SMPLObject mod(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLDouble) {
            return new SMPLDouble(value % ((SMPLDouble) obj).getValue());
        } else {
            throw new SMPLException("Cannot perform modulo operation on non-double values");
        }
    }

}