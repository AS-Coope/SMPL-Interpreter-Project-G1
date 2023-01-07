public class SMPLObject {

    /*All methods here will be overriden in the Type class (that inherits SMPLObject)
      where they are necessary to be overriden
      (Ex: SMPLPair would not inherit, and implement, the add method because it does need that 
      functionality)   
       
      If a Type invokes method it does not use, an SMPLException should be thrown signifying that
      this Type as not having a need for that method
    */
    public SMPLObject(){

    }

    public SMPLObject add(SMPLObject addVal) throws SMPLException{
        return addVal;
    }

    public SMPLObject sub(SMPLObject subVal) throws SMPLException{
        return subVal;
    }

    public SMPLObject mult(SMPLObject multVal) throws SMPLException{
        return multVal;
    }

    public SMPLObject div(SMPLObject divVal) throws SMPLException{
        return divVal;
    }

    public SMPLObject substr(SMPLObject subStrVal) throws SMPLException{
        return subStrVal;
    }

    public SMPLObject cdr(SMPLObject cdrVal) throws SMPLException{
        return cdrVal;
    }

    public SMPLObject car(SMPLObject carVal) throws SMPLException{
        return carVal;
    }

    public SMPLObject iseqv(SMPLObject iseqvVal) throws SMPLException{
        return iseqvVal;
    }
    
    public SMPLObject isequal(SMPLObject isequalVal) throws SMPLException{
        return isequalVal;
    }
}
