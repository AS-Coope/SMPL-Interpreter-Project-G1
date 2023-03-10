import java.lang.Math;

public class SMPLDouble extends SMPLObject {
    private double value;

    public SMPLDouble(double value) {
        this.value = value;
    }

    // empty constructor for default initialization
    public SMPLDouble() {
        
    }

    public double getValue() {
        return value;
    }

    public void setValue(double val){
        this.value = val;
    }

    public double valueOf(int val){
        this.value = (double) val;
        return value;
    }

    // arithmetic operators

    // does calculations for both int and doubles
    @Override
    public SMPLObject add(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLDouble) {
            return new SMPLDouble(value + ((SMPLDouble) obj).getValue());
        } else if (obj instanceof SMPLInt){
            return new SMPLDouble(value + ((SMPLDouble) obj).getValue());
        } else {
            throw new SMPLException("Cannot add non-double values");
        }
    }

    // does calculations for both int and doubles
    @Override
    public SMPLObject sub(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLDouble) {
            return new SMPLDouble(value - ((SMPLDouble) obj).getValue());
        } else if (obj instanceof SMPLInt){
            return new SMPLDouble(value - ((SMPLDouble) obj).getValue());
        } else {
            throw new SMPLException("Cannot subtract non-double values");
        }
    }

    // does calculations for both int and doubles
    @Override
    public SMPLObject mult(SMPLObject obj) throws SMPLException {

        if (obj instanceof SMPLDouble) {
            return new SMPLDouble(value * ((SMPLDouble) obj).getValue());
        }  else if (obj instanceof SMPLInt){
            return new SMPLDouble(value * ((SMPLDouble) obj).getValue());
        }else {
            throw new SMPLException("Cannot multiply non-double values");
        }
    }

    // does calculations for both int and doubles
    @Override
    public SMPLObject div(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLDouble) {
            return new SMPLDouble(value / ((SMPLDouble) obj).getValue());
        } else if (obj instanceof SMPLInt){
            return new SMPLDouble(value / ((SMPLDouble) obj).getValue());
        }else {
            throw new SMPLException("Cannot divide non-double values");
        }
    }

    @Override
    public SMPLObject mod(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLDouble) {
            return new SMPLDouble(value % ((SMPLDouble) obj).getValue());
        } else if (obj instanceof SMPLInt){
            return new SMPLDouble(value % ((SMPLDouble) obj).getValue());
        }else {
            throw new SMPLException("Cannot perform modulo operation on non-double values");
        }
    }

    // the power (exponent) function
    /* 
    @Override
    public SMPLObject raise(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLDouble) {
            SMPLDouble x = ((SMPLDouble) obj).getValue();

            return new SMPLDouble(Math.pow(value, x).getValue());
        } else {
            throw new SMPLException("Cannot perform power operation on non-double values");
        }
    }*/

    // relational operators

    @Override
    public SMPLObject lessthan(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLDouble) {
            return new SMPLBoolean(value < ((SMPLDouble) obj).getValue());
        } else if (obj instanceof SMPLInt){
            return new SMPLBoolean(value < ((SMPLDouble) obj).getValue());
        } else {
            throw new SMPLException("Cannot perform less than operation on non-double values");
        }
    }

    @Override
    public SMPLObject greaterthan(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLDouble) {
            return new SMPLBoolean(value > ((SMPLDouble) obj).getValue());
        } else if (obj instanceof SMPLInt){
            return new SMPLBoolean(value > ((SMPLDouble) obj).getValue());
        } else {
            throw new SMPLException("Cannot perform greater than operation on non-double values");
        }
    }

    @Override
    public SMPLObject greateqto(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLDouble) {
            return new SMPLBoolean(value >= ((SMPLDouble) obj).getValue());
        } else if (obj instanceof SMPLInt){
            return new SMPLBoolean(value >= ((SMPLDouble) obj).getValue());
        } else {
            throw new SMPLException("Cannot perform greater than or equal to operation on non-double values");
        }
    }

    @Override
    public SMPLObject lesseqto(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLDouble) {
            return new SMPLBoolean(value <= ((SMPLDouble) obj).getValue());
        } else if (obj instanceof SMPLInt){
            return new SMPLBoolean(value <= ((SMPLDouble) obj).getValue());
        } else {
            throw new SMPLException("Cannot perform less than or equal to operation on non-double values");
        }
    }

    @Override
    public SMPLObject equalto(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLDouble) {
            return new SMPLBoolean(value == ((SMPLDouble) obj).getValue());
        } else if (obj instanceof SMPLInt){
            return new SMPLBoolean(value == ((SMPLDouble) obj).getValue());
        } else {
            throw new SMPLException("Cannot perform equal to operation on non-double values");
        }
    }

    @Override
    public SMPLObject notequal(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLDouble) {
            return new SMPLBoolean(value != ((SMPLDouble) obj).getValue());
        } else if (obj instanceof SMPLInt){
            return new SMPLBoolean(value != ((SMPLDouble) obj).getValue());
        } else {
            throw new SMPLException("Cannot perform not equal to operation on non-double values");
        }
    }

    @Override
    public SMPLObject iseqv(SMPLObject obj) throws SMPLException {
        if (obj instanceof SMPLDouble) {
            SMPLDouble other = (SMPLDouble) obj;

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
        return String.valueOf(value);
    }
}