public abstract class SMPLObject {

    /*
     * All methods here will be overriden in the Type class (that inherits
     * SMPLObject)
     * where they are necessary to be overriden
     * (Ex: SMPLPair would not inherit, and implement, the add method because it
     * does need that
     * functionality)
     * 
     * If a Type invokes method it does not use, an SMPLException should be thrown
     * signifying that
     * this Type as not having a need for that method
     */
    // SMPLObject value;
    public SMPLObject() {

    }

    /*
     * public SMPLObject(SMPLObject val){
     * this.value = val;
     * }
     */

    // Arithmetic Methods
    public SMPLObject add(SMPLObject obj) throws SMPLException {
        throw new SMPLException("Method not implemented");
    }

    public SMPLObject sub(SMPLObject obj) throws SMPLException {
        throw new SMPLException("Method not implemented");
    }

    public SMPLObject mult(SMPLObject obj) throws SMPLException {
        throw new SMPLException("Method not implemented");
    }

    public SMPLObject div(SMPLObject obj) throws SMPLException {
        throw new SMPLException("Method not implemented");
    }

    public SMPLObject raise(SMPLObject obj) throws SMPLException {
        throw new SMPLException("Method not implemented");
    }

    public SMPLObject mod(SMPLObject obj) throws SMPLException {
        throw new SMPLException("Method not implemented");
    }

    // Relational Methods

    // <
    public SMPLObject lessthan(SMPLObject obj) throws SMPLException {
        throw new SMPLException("Method not implemented");
    }

    // >
    public SMPLObject greaterthan(SMPLObject obj) throws SMPLException {
        throw new SMPLException("Method not implemented");
    }

    // =
    public SMPLObject equalto(SMPLObject obj) throws SMPLException {
        throw new SMPLException("Method not implemented");
    }

    // >=
    public SMPLObject greateqto(SMPLObject obj) throws SMPLException {
        throw new SMPLException("Method not implemented");
    }

    // <=
    public SMPLObject lesseqto(SMPLObject obj) throws SMPLException {
        throw new SMPLException("Method not implemented");
    }

    // !=
    public SMPLObject notequal(SMPLObject obj) throws SMPLException {
        throw new SMPLException("Method not implemented");
    }
    // arbitrary methods

    public SMPLObject substr(SMPLObject startIndex, SMPLObject endIndex) throws SMPLException {
        throw new SMPLException("Method not implemented");
    }

    public SMPLObject constructListOfPairs() throws SMPLException {
        throw new SMPLException("Method not implemented");
    }

    public SMPLObject isTrue() throws SMPLException {
        throw new SMPLException("Method not implemented");
    }

    // pair (and subsequently) list operations
    public SMPLObject cdr() throws SMPLException {
        throw new SMPLException("Method not implemented");
    }

    public SMPLObject car() throws SMPLException {
        throw new SMPLException("Method not implemented");
    }

    public SMPLObject iseqv(SMPLObject obj) throws SMPLException {
        return new SMPLBoolean(this == obj);
    }

    public SMPLObject isequal(SMPLObject obj) throws SMPLException {
        return new SMPLBoolean(this.equals(obj));
    }

    public SMPLObject isPair() throws SMPLException {
        return new SMPLBoolean(false);
    }

    public SMPLObject size() throws SMPLException {
        throw new SMPLException("Method not implmented");
    }
}
