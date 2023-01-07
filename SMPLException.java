/*Exception that runs when a method is being invoked on a type that does
 * that does not implement that method
*/

public class SMPLException extends VisitException {
    public SMPLException (String issue){
        super("This variable's type does not implement this method..." + issue);
    }

    public SMPLException(String issue, Throwable cause){
        super(issue, cause);
    }
}
